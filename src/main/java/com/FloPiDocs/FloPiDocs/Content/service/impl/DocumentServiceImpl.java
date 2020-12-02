package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.model.dto.TagDTO;
import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.DocumentRepository;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import com.itextpdf.text.*;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.itextpdf.text.pdf.PdfPTable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    TagService tagService;

    @Autowired
    FieldService fieldService;

    @Autowired
    UserService userService;

    @Autowired
    private ConversionService conversionService;

    /**
     * Create document
     * @param documentDTO
     * @return documentDto
     */
    @Override
    public DocumentDTO createDocument(DocumentDTO documentDTO) {
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDateTime ldt = LocalDateTime.now();
        String formatedDate = formmat1.format(ldt);
        documentDTO.setDate(formatedDate);
        Document doc = documentRepository.save(conversionService.convert(documentDTO, Document.class));
        return conversionService.convert(doc, DocumentDTO.class);
    }

    /**
     * Export document
     * @param documentId
     * @return ByteArrayInputStream
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    @Override
    public ByteArrayInputStream exportDocument(String documentId) throws FileNotFoundException, DocumentException {
        Document document = documentRepository.findById(documentId).orElseThrow();
        List<FieldDTO> fieldList = fieldService.findByDocumentId(documentId);

        UserDTO userDTO = conversionService.convert(userService.findByUserId(document.getUserId()), UserDTO.class);
        String userName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String email = userDTO.getEmail();

        //SETTINGS
        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        com.itextpdf.text.Document pdf = new com.itextpdf.text.Document();
        PdfWriter.getInstance(pdf, out);
        pdf.open();

        //DOCUMENT TOP
        String documentInit = "OFFICIAL FloPiDoc";
        String documentPurpose = "ESTE PROGRAMA ESTÁ CREADO CON FINES DIDÁCTICOS Y NO ESTÁ PERMITIDA SU MONETIZACIÓN, AUNQUE SI SE CONSIGUE USTED ES UN CAPO";

        pdf.add(new Paragraph(documentInit));
        pdf.add(new Paragraph(documentPurpose));
        pdf.add(new Paragraph("                                          "));

        //DIVIDER
        DottedLineSeparator dottedline = new DottedLineSeparator();
        dottedline.setOffset(-2);
        dottedline.setGap(2f);
        pdf.add(dottedline);
        pdf.add(new Paragraph("                                          "));

        //USER DATA
        String userData = "USER: " + userName + lastName + " , EMAIL: " + email;
        PdfPTable userDatatable = new PdfPTable(2);
        userDatatable.setWidthPercentage(60);
        userDatatable.setWidths(new int[]{3, 3});

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("USER NAME", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        userDatatable.addCell(hcell);

        hcell = new PdfPCell(new Phrase("EMAIL", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        userDatatable.addCell(hcell);

        hcell = new PdfPCell(new Phrase(userName + " " + lastName));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        userDatatable.addCell(hcell);

        hcell = new PdfPCell(new Phrase(email));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        userDatatable.addCell(hcell);

        pdf.add(userDatatable);
        pdf.add(new Paragraph("                                          "));

        //DOCUMENT DATA
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(60);
        table.setWidths(new int[]{3, 3, 3});

        hcell = new PdfPCell(new Phrase("DOC TITLE", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("DOC PURPOSE", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("DATE", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase(document.getTitle()));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase(document.getPurpose()));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase(document.getDate()));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        pdf.add(table);
        pdf.add(new Paragraph("                                          "));

//      FieldList
        PdfPTable fieldDatatable = new PdfPTable(2);
        fieldDatatable.setWidthPercentage(95);
        fieldDatatable.setWidths(new int[]{2, 10});

        hcell = new PdfPCell(new Phrase("FIELD NAME", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        fieldDatatable.addCell(hcell);

        hcell = new PdfPCell(new Phrase("FIELD VALUE", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        fieldDatatable.addCell(hcell);

        fieldList.forEach(field -> {
            PdfPCell hcell1;
            hcell1 = new PdfPCell(new Phrase(field.getFieldName()));
            hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            fieldDatatable.addCell(hcell1);

            if (field.getFieldValue() != null) {
                hcell1 = new PdfPCell(new Phrase(field.getFieldValue()));
                hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                fieldDatatable.addCell(hcell1);
            } else {
                //PICTURE
                String base64Image = field.getFieldPicture().split(",")[1];
                byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(imageBytes));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Image imageText = Image.getInstance(imageBytes);
                    hcell1 = new PdfPCell(imageText, true);
                    hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    fieldDatatable.addCell(hcell1);
                } catch (BadElementException | IOException e) {
                    e.printStackTrace();
                }

            }
        });

        pdf.add(fieldDatatable);
//        pdf.add(new Paragraph("                                          "));

        pdf.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

    @Override
    public List<DocumentDTO> findByTitle(String title) {
        return documentRepository.findByTitle(title).stream().map(doc -> conversionService.convert(doc, DocumentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DocumentDTO findById(String documentId) {
        Document optDocument = documentRepository.findById(documentId).orElseThrow();
        return conversionService.convert(optDocument, DocumentDTO.class);
    }

    @Override
    public List<DocumentDTO> findByPurpose(String purpose) {
        return documentRepository.findByPurpose(purpose).stream().map(doc -> conversionService.convert(doc , DocumentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<Document> findAll() {
        return null;
    }

    @Override
    public List<Document> findByUserId(String userId, Pageable pageable) {
        return documentRepository.findByUserId(userId, pageable);
    }

    @Override
    public List<DocumentDTO> findAllByUserId(String userId) {
        List<Document> documentList = documentRepository.findAllByUserId(userId);
        return documentList.stream().map(doc -> conversionService.convert(doc, DocumentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public boolean emailExists(String email) {
        return false;
    }

    @Override
    public DocumentDTO deleteById(DocumentDTO documentDTO) {
        DocumentDTO documentDTO1 = findById(documentDTO.getId());
        documentRepository.deleteById(documentDTO1.getId());
        tagService.deleteByDocumentId(documentDTO.getId());
        fieldService.deleteByDocumentId(documentDTO.getId());
        return conversionService.convert(documentDTO1, DocumentDTO.class);
    }

    @Override
    public void deleteByUserId(String userId) {
        documentRepository.deleteByUserId(userId);
    }

    @Override
    public void deleteByTitle(String title) {
        documentRepository.deleteByTitle(title);
    }

    @Override
    public void deleteAll() {
        documentRepository.deleteAll();
    }

    @Override
    public void save(Document document) {
        documentRepository.save(document);
    }

    @Override
    public void deleteAllByUserId(String userId) {
        List<DocumentDTO> documentList = findAllByUserId(userId);
        documentList.forEach(documentDTO -> {
                    fieldService.deleteByDocumentId(documentDTO.getId());
                    tagService.deleteByDocumentId(documentDTO.getId());
                }
        );
        deleteByUserId(userId);
    }

    @Override
    public Long countByUserId(String userId) {
        return documentRepository.countByUserId(userId);
    }

    /**
     * Find documents by User and Title
     * @param userId
     * @param key
     * @return List<DocumentDto>
     */
    @Override
    public List<DocumentDTO> findByUserIdAndTitle(String userId, String key) {
        List<Document> documentList = documentRepository.findByUserIdAndTitleContainsIgnoreCase(userId, key);
        return documentList.stream().map(doc -> conversionService.convert(doc , DocumentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentDTO> findByUserIdAndPurpose(String userId, String purpose) {
        List<Document> documentList = documentRepository.findByUserIdAndPurposeContainsIgnoreCase(userId, purpose);
        return documentList.stream().map(doc -> conversionService.convert(doc, DocumentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void update(DocumentDTO documentDTO) {
        Document document = conversionService.convert(documentDTO, Document.class);
        save(document);
    }

    @Override
    public List<DocumentDTO> findByUserIdAndTag(String userId, String key) {
        List<TagDTO> tagDTO = tagService.findByUserIdAndTagName(userId, key);

        List<Document> documentList = tagDTO.stream().map(tag -> {
                    if (documentRepository.findById(tag.getDocumentId()).isPresent()) {
                        return documentRepository.findById(tag.getDocumentId()).get();
                    } else return new Document();
                }
        ).collect(Collectors.toList());

        return documentList.stream().map(document -> conversionService.convert(document, DocumentDTO.class)).collect(Collectors.toList());
    }

}
