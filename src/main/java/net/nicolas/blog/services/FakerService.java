package net.nicolas.blog.services;

/**
 * Responsible for creating dummy data
 * to feed the data base to make tests
 */
public interface FakerService {
    String fullName();
    String sportsHeadLine();
    String textLine();
    String paragraphText(Integer n);
    String anyWord();
    Integer anyDigit();
    String imageUrls();
}
