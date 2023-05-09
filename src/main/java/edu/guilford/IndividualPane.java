package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

// IndividualPane is a class that extends one of the Pane classes
public class IndividualPane extends GridPane {
    // Could have GridPane, TitlePane, StackPane, Pane, BoarderPane, and others
    // These organize the components we want to display in different ways 

    // Four String attributes for the individual's name, email, phone, and birthday
    // private String name; 
    // private String email; 
    // private String phone;
    // private String birthday;

    // Individual attribute 
    private Individual individual;
    
    // add a textfield attribute for the name 
    // add a textfield attribute for the email
    // add a textfield attribute for the phone
    // add a textfield attribute for the birthday

    private TextField nameField;
    private TextField emailField;
    private TextField phoneField;
    private TextField ageField;

    // add a submit button attribute
    private Button submitButton; 

    // add a date picker attribute
    private DatePicker datePicker;

    // three Label attributes for the name, email, phone,and birthdya
     private Label nameLabel;
     private Label emailLabel;
     private Label phoneLabel;
     private Label ageLabel;
     private Label dateLabel; 

     // Step 1: Declare an ImageView attribute
    private ImageView imageView;


    private boolean valid; // boolean attribute to check if the input is valid
    private int n; // int attribute to check if the phone number is valid
    private Label errorLabel; // Label attribute to display error messages
    private Label stackTraceLabel; // Label attribute to display stack trace

    private boolean valid2;
    private Label errorLabel2;
    private Label stackTraceLabel2;


    // Constructor
    public IndividualPane(Individual individual)  { 
        // Set the individual attribute to the individual parameter
        this.individual = individual;

        // Instantiate a submit button
        submitButton = new Button("Submit");

        // Instantiate a date picker
        datePicker = new DatePicker();

        // Step 2: Instantiate the ImageView attribute with the image we want to display
        // Get the path of file that contains the image 
        File file = new File(this.getClass().getResource("Miami-Heat-logo.png")
        .getPath());
        
        // URI stands for Uniform Resource Identifier and it's similar to a URL
        imageView = new ImageView(file.toURI().toString()); 
        

        // instantiate textField attributes
        nameField = new TextField();
        emailField = new TextField();
        phoneField = new TextField();
        ageField = new TextField();

        // instantiate textfield attributes 
        nameField = new TextField();
        emailField = new TextField();
        phoneField = new TextField();
        ageField = new TextField();

        // instantiate label attributes
        nameLabel = new Label("Name: " + individual.getName());
        emailLabel = new Label("Email: " + individual.getEmail());
        phoneLabel = new Label("Phone: " + individual.getPhone());
        ageLabel = new Label("Age: " + individual.getAge());
        dateLabel = new Label("Date: " + individual.getDate()); 
       
        errorLabel = new Label();
        stackTraceLabel = new Label();
        errorLabel2 = new Label();
        stackTraceLabel2 = new Label();
    
        // Add a label to the pane
        this.add(nameLabel, 0, 0);
        // Add a label to the pane
        this.add(emailLabel, 0, 1);
        // Add a label to the pane
        this.add(phoneLabel, 0, 2);
        // Add a label to the pane
        this.add(ageLabel, 0, 3);
        // Add a label to the pane
        this.add(dateLabel, 0, 4);

        // Add nameField to the pane next to the name label 
        this.add(nameField, 1, 0);  
        // Add emailField to the pane next to the email label
        this.add(emailField, 1, 1);
        // Add phoneField to the pane next to the phone label
        this.add(phoneField, 1, 2);
        // Add ageField to the pane next to the age label
        this.add(ageField, 1, 3);
        // Add the submit button to the pane
        this.add(submitButton, 0, 5);
        // Add the date picker to the pane
        this.add(datePicker, 1, 4);

        // add the error label besides the text fields
        this.add(errorLabel, 3, 5);
        // add the stack trace label besides the text fields
        this.add(stackTraceLabel, 3, 6);
        // // add errorLabel2 beside errorLabel
        // this.add(errorLabel2, 5, 7);
        // // add stackTraceLabel2 beside stackTraceLabel
        // this.add(stackTraceLabel2, 5, 8);

        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

        // Step 3: Add the ImageView to the bottom right of the pane
        this.add(imageView, 2, 5);
        
        // Give the pane a border
        this.setStyle("-fx-border-color: black");
        // make the board thicker
        this.setStyle("-fx-border-width: 10px");
        // add a background color 
        this.setStyle("-fx-background-color: lightblue");

        // Add a listener for the button that changes the labels
        submitButton.setOnAction(e -> {
            // update the individual attribute with the new data 
            individual.setName(nameField.getText());
            individual.setEmail(emailField.getText());
            individual.setPhone(Integer.parseInt(phoneField.getText()));  

            try {
                individual.setAge(Integer.parseInt(ageField.getText()));
                n = individual.getAge();
                if (n == 0) {
                    throw new BadNumberException("Bad Number. Age cannot be " + n);
                }
                valid = true;
            } catch (NumberFormatException ex) {
                // put the stack trace in the stackTraceLabel
                stackTraceLabel.setText("Please enter an integer for age");
                // Display the error message in the label
                errorLabel.setText("Incorrect Input for Age ");
                // flush the errorLabel so that it erases the previous message

            } catch (BadNumberException ex) {
                // Display the stack trace in the stackTraceLabel
                stackTraceLabel.setText(ex.getMessage());
            } if (valid) {
                errorLabel.setText("");
                stackTraceLabel.setText("");
            }

            //Write a try-catch block to catch the NoEntryException
            try {
                if (nameField.getText().equals("") || emailField.getText().equals("") || 
                phoneField.getText().equals("") || ageField.getText().equals("") || 
                dateLabel.getText().equals("")) {
                    throw new NoEntryException("No Entry. Please enter all fields");
                }
                valid2 = true;
            } catch (NoEntryException ex) {
                stackTraceLabel2.setText(ex.getMessage());
                errorLabel2.setText("No Entry ");
            } if (valid2) {
                errorLabel2.setText("");
                stackTraceLabel2.setText("");
            }

            // Set the name label to the name field's text
            nameLabel.setText("Name: " + individual.getName());
            // Set the email label to the email field's text
            emailLabel.setText("Email: " + individual.getEmail());
            // Set the phone label to the phone field's text
            phoneLabel.setText("Phone: " + individual.getPhone());
            // Set the birthday label to the birthday field's text
            ageLabel.setText("Age: " + individual.getAge());
            // Set the date label to the date picker's text
            dateLabel.setText("Date: " + individual.getDate());
        });
       
    }
    
    private static class BadNumberException extends Exception {
        // All we need in this class is a constructor that tells what is supposed to happen 
        // when the exception is thrown
        public BadNumberException(String message) {
            // our construtor has one parameter: the message we want to send when this exception is thrown
            super(message);
        }
    }

    private static class NoEntryException extends Exception {
        public NoEntryException(String message) {
            super(message);
        }
    }
    
}
