package main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book {
	//Information about each single book:
	private int id;
	private String title, author, genre;
	private LocalDate lastCheckOutDate;
	private boolean checkedOut;
	
	//Constructor
	public Book(int id, String title, String author, String genre, LocalDate lastCheckOutDate, boolean checkedOut) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.lastCheckOutDate = lastCheckOutDate;
		this.checkedOut = checkedOut;
	}
	
	//Getters and Setters functions
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public LocalDate getLastCheckOut() {
		return lastCheckOutDate;
	}
	public void setLastCheckOut(LocalDate lastCheckOut) {
		this.lastCheckOutDate = lastCheckOut;
	}
	public boolean isCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	@Override
	public String toString() {
		/* This is supposed to follow the format
		 * {TITLE} By {AUTHOR}
		 * Both the title and author are in uppercase. */
		return title.toUpperCase() + " BY " + author.toUpperCase();
	}
	public float calculateFees() {
		//According the rubric today's date is 2023/15/8 + 31 Days (23/15/9).
		LocalDate from31Days = LocalDate.of(2023, 9, 15); 
		long daysPassed = lastCheckOutDate.until(LocalDate.of(2023, 9, 15), ChronoUnit.DAYS);
		
		/* fee (if applicable) = base fee + 1.5 per additional day */
		if(lastCheckOutDate.isBefore(LocalDate.of(2023, 8, 16))) 
			return (float) (10 + 1.5 * ((int)(daysPassed) - 31));
		return 0.0f;
	}
}
