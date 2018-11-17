package com.elib.dedamraz.model;

import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
@Table(name = "wish_list_item")
public class WishListItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@Length(min = 5, message = "*The wish list item must have at least 5 characters")
    @NotEmpty(message = "*Please provide the wish list item name")
	@Column(name = "item_name")
	private String itemName;
	
	@Size(max = 300)
	@Column(name = "item_description")
	private String itemDescription;
	
	@Size(max = 300)
	@Column(name = "item_url")
	private URL	itemUrl;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
