package cpen221.mp2;

import cpen221.mp2.Exceptions.InvalidEmailException;

import java.text.BreakIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Email {
    private int sender;
    private int receiver;
    private int timeStamp;

    public Email (int sender, int receiver, int timeStamp){
        this.sender = sender;
        this.receiver = receiver;
        this.timeStamp = timeStamp;
    }

    /**
     * Creates an Email from a String containing at least three integers.
     * The first three integers in the string will be used, where the:
     *     First integer is the id of the sender
     *     Second integer is the id of the receiver
     *     Third integer is the timestamp of the email
     *
     * @param emailData String containing email information
     * @throws InvalidEmailException if the string does not contain at least
     *                               three values
     */
    public Email (String emailData) throws InvalidEmailException {
        Scanner scanner = new Scanner(emailData);
        try {
            int[] emailNumbers = new int[3];
            for (int i = 0; i < 3; i++){
                emailNumbers[i] = scanner.nextInt();
            }
            sender = emailNumbers[0];
            receiver = emailNumbers[1];
            timeStamp = emailNumbers[2];
        } catch (NoSuchElementException e){
            //TODO: probably remove printout
            System.out.println("Detected line with less than three entries" +
                    " ensure input data is formatted properly");
            throw new InvalidEmailException();
        }
    }

    /**
     * Returns the id of the sender of the email
     * @return id of sender
     */
    public int getSender (){
        return sender;
    }

    /**
     * Returns the id of the receiver of the email
     * @return id of receiver
     */
    public int getReceiver (){
        return receiver;
    }

    /**
     * Returns timeStamp of the email in seconds
     * @return id of timeStamp
     */
    public int getTimeStamp (){
        return timeStamp;
    }
}
