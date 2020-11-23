package com.tcs.springbootdemo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Proxy(lazy=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
	@Id
	private long id;
	private int number;
	private String content;
	private String chapter;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	private Book book;
}
