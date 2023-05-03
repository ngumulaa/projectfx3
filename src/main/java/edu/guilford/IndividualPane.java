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


        // Step 3: Add the ImageView to the pane to the right of the textfields
        this.add(imageView, 2, 0, 1, 4);

        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

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
            // individual.setPhone(Integer.parseInt(phoneField.getText()));  
            individual.setAge(Integer.parseInt(ageField.getText()));

            try {
                individual.setPhone(Integer.parseInt(phoneField.getText()));
                n = individual.getPhone();
                if (n == 0) {
                    throw new BadNumberException("Bad Number. Phone cannot be " + n);
                }
                valid = true;
            } catch (NumberFormatException ex) {
                // put the stack trace in the stackTraceLabel
                stackTraceLabel.setText(ex.getMessage());
                // Display the error message in the label
                errorLabel.setText("Input for age is not an integer ");
                // flush the errorLabel so that it erases the previous message

            } catch (BadNumberException ex) {
                // Display the stack trace in the stackTraceLabel
                stackTraceLabel.setText(ex.getMessage());
            } if (valid) {
                errorLabel.setText("");
                stackTraceLabel.setText("");
            }


            
            // Set the name label to the name field's text
            nameLabel.setText("Name: " + nameField.getText());
            // Set the email label to the email field's text
            emailLabel.setText("Email: " + emailField.getText());
            // Set the phone label to the phone field's text
            phoneLabel.setText("Phone: " + phoneField.getText());
            // Set the birthday label to the birthday field's text
            ageLabel.setText("Age: " + ageField.getText());
            // Set the date label to the date picker's text
            dateLabel.setText("Date: " + datePicker.getValue());

            System.out.println(e.toString());
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
    
}
