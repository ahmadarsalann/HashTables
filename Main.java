package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        ArrayList<String> two = new ArrayList<>();//Array List to hold 2 word elements
        HashTable<String, Integer> sentiments = new HashTable<>(100000);//Hashtable to store data from sentiment.txt
        try{//try the following code. If fails do the catch
            File file = new File("sentiments.txt");//Reading in file "sentiment.txt"
            Scanner bob = new Scanner(file);//Scanning file
            while(bob.hasNextLine()){//while the file has a readable line
                String[] data = bob.nextLine().split(",");//In each line split at the ","
                String get = data[0];//To get the key
                char a;//For manipulation
                for(int i = 0; i < get.length(); i++){//For loop
                    a = get.charAt(i);//If a stumbles upon a space
                    if(a == ' '){//
                        two.add(get);//add it to the arrayList

                    }//end of if
                }//end of for

                sentiments.insert(data[0], Integer.parseInt(data[1]));//add all the data to Hashtable from sentiments.txt
            }//end of while loop
        }catch(FileNotFoundException e){//catch block if file not found
            System.out.println("File not found");//Prints File not found
        }//end of catch
        Scanner universal = new Scanner(System.in);//Scanner to scan user input
        System.out.println("Enter text: ");//Prints enter text
        String input = "";//For input
        int b = 0;//for cases to be tested
        while(!input.endsWith("END")){//if the input ends with "END" then stop otherwise keep scanning
            if(b==0){//
                input = universal.nextLine();//if b equals 0 take next line as input
            }
            else {
                input = input + " " + universal.nextLine();//if not then do input + next line
            }
            b++;//increment b at the end of while loop
        }//end of while
        input = input.substring(0, input.length()-3);//delete the last the letters from input which are "END"
        char k;//for manipulation
        for(int m = 0; m < input.length(); m++){//for loop to scan the input string
             k = input.charAt(m);//k is keeping track of each letter
             if((k == ',' || k == '.' || k == '!' || k == ';' || k == '"' || k == '?' || k == ':')){//if k stumbles upon any of these cases delete them
                input = input.substring(0, m) + input.substring(m + 1);
                m--;//decrements m so that the program doesn't skip a char
             }//end of if
        }//end of for
        input = input.toLowerCase();//convert to lower case

        String[] input2 = input.split(" ");//split at space and store in input2 array

        double words = input2.length - 1;//keep track of all the words
        double total = 0;//keep track of sentiments
       for(int g = 0; g < input2.length; g++) {//for loop to scan the user input and find sentiments
           if(g+1<input2.length){//if g+1 is less then the length of the string
                 String cool = input2[g] + " " + input2[g+1];//String cool to get the first and second string with a space in between
                    if(two.contains(cool)) {//if arraylist of spaced words contain cool then
                        total = total + sentiments.lookup(cool);//lookup from hashtable and add to the total
                    }//end of sub if
           }if(sentiments.lookup(input2[g]) != null){//if the sentiments lookup method doesn't returns null
               total = total + sentiments.lookup(input2[g]);//lookup and add it to the total
           }//end of else

        }//end of main for
        double overall = total / words;//to get the average
            System.out.println("Words " + words);//to print number of words
            System.out.println("Sentiment: " + total);//to print the total sentiment
            System.out.printf("Overall: %.2f", overall);//to print the average



    }//end of main
}//end of full main
