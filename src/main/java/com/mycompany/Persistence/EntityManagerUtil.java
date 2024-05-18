/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;





/**
 *
 * @author macuser
 */
public class EntityManagerUtil {

 public static EntityManager getEntityManager(){
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("PlannetproProyect_Persistense"); 
    EntityManager manager = factory.createEntityManager();
    return manager;
}
    public static void main(String[] args) {
      EntityManager manager = EntityManagerUtil.getEntityManager(); 
      System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
}
    }
 
