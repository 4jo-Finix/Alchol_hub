package com.teamphoenix.ahub.postreply.command.aggregate;//package com.teampheonix.postreply.command.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="post_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PostCategory {

    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

}
