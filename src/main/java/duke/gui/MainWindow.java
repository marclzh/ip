package duke.gui;

import duke.Duke;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    /**
     * String input to exit program.
     **/
    private static final String END_PROGRAM = "bye";

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/elgato.jpg"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/elp.png"));

    /**
     * Initializes the chat box.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        scrollPane.setFitToWidth(true);
        // Greet User
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(UI.greet(), dukeImage));
    }

    /**
     * Sets the Elp chatbot instance.
     *
     * @param d
     */
    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage)
        );
        double height = userInput.getMaxHeight();
        dialogContainer.setPrefHeight(height);
        userInput.clear();
        if (input.equals(END_PROGRAM)) {
            Platform.exit();
        }
    }
}
