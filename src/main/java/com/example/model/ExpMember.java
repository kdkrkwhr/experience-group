package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpMember {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int memberNo;

   private int experienceNo;

   private String blogAddress;
   private String email;
   private String name;
   private String phone;
   private String address;
   private String prdName;
   private String memo;

   @Builder
   public ExpMember(int experienceNo, String blogAddress, String email, String name, String phone, String address, String prdName, String memo) {

      this.experienceNo = experienceNo;
      this.blogAddress = blogAddress;
      this.email = email;
      this.name = name;
      this.phone = phone;
      this.address = address;
      this.prdName = prdName;
      this.memo = memo;

   }
}