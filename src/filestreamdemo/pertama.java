/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filestreamdemo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jarvvis
 */
public class pertama {
     FileOutputStream out = null;
    FileInputStream input = null;
    int data;
    String copy ="";
    
    public void tulisFile(String data){
        try {
            out =  new FileOutputStream("D:\\Images\\fileLama.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        //menulis
        try {
            for (int i = 0; i < data.length(); i++) {
                //konversi data
                out.write((int)data.charAt(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //tutup
        try {
            out.close();
        } catch (Exception e) {
        }
    }
    
    public void readFile(String namaFile){
        //membuka file
        try {
            input = new FileInputStream("D:\\Images\\fileLama.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan !");
        }
        
        try {
            while ((data = input.read())!= -1) {                
                System.out.print((char)data);
                copy += String.valueOf((char)data);
            }
            System.out.println("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //tutup
        try {
            out.close();
        } catch (Exception e) {
        }
    }
    
    public void copyCopy(){
        try {
            out =  new FileOutputStream("D:\\Images\\fileNew.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        //menulis
        try {
            for (int i = 0; i < copy.length(); i++) {
                //konversi data
                out.write((int)copy.charAt(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //tutup
        try {
            out.close();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
     InputStreamReader in = new InputStreamReader(System.in);
 BufferedReader br = new BufferedReader(in);
  
 pertama iofile = new pertama();
       String data = "";
        
        System.out.println("********************************");
        System.out.println("*******INPUT OUTPUSSSS**********");
        System.out.println("********************************\n");
        
  try {
   System.out.print("Masukkan data : ");
   data = br.readLine();
   iofile.tulisFile(data);
   System.out.print("Isi asliii: ");
   iofile.readFile("ini_asli");
   
   System.out.print("Salin data? (Y/N) : ");
   String pilih = br.readLine();
   
   if(pilih.equalsIgnoreCase("Y")){
    iofile.copyCopy();
    System.out.print("Isi file baru : ");
    iofile.readFile("ini_tiruan");
   }else{
    System.exit(0);
   }
   
  } catch (Exception e) {
   // TODO: handle exception
  }
    }
}

