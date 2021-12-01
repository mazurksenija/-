
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.FileWriter;
import java.io.IOException;
;

import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import javax.swing.*;
import java.util.Objects;



public class KursachFormController {


    @FXML
    private AnchorPane parent;


    @FXML
    private TableColumn<Requirement, Integer> col_id;
    @FXML
    private TableColumn<Requirement, String> col_type;
    @FXML
    private TableColumn<Requirement, String> col_info;
    @FXML
    private TableColumn<Requirement, String> col_start;
    @FXML
    private TableColumn<Requirement, String> col_end;
    @FXML
    private TableColumn<Requirement, Integer> col_fk_id;
    @FXML
    private TableView<Requirement> tab_req;
    @FXML
    private TableColumn<User, Integer> col_id_user;

    @FXML
    private TableColumn<Search_pr, String> col_name;
    @FXML
    private TableColumn<Search_pr, String> col_surname;
    @FXML
    private TableColumn<Search_pr, String> col_position;
    @FXML
    private TableView<Search_pr> tab_pr;

    @FXML
    private TableView<User> user;

    int index = -1;
    @FXML
    private TextField txt_project;
    @FXML
    private ChoiceBox<String> box_id_pr;
    @FXML
    private ChoiceBox<String> box_project;

    @FXML
    private TextField id;
    @FXML
    private TextField type;
    @FXML
    private TextField info;
    @FXML
    private TextField start;
    @FXML
    private TextField end;
    @FXML
    private TextField fk_id_pr;
    @FXML
    private TextField del_info;

    @FXML
    private TextField id_field;
    @FXML
    private TextField txt_type;
    @FXML
    private TextField txt_info;
    @FXML
    private TextField txt_start;
    @FXML
    private TextField txt_end;
    @FXML
    private TextField txt_fk_id_pr;
    @FXML
    private TextField txt_old_id;
    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_name;
    @FXML
    private TextField txt_surname;
    @FXML
    private TextField txt_status;

    @FXML
    private TextField txt_search;

    public KursachFormController() {

    }

    @FXML
    private void initialize() throws IOException, ClassNotFoundException {


        box_id_pr.setItems(FXCollections.observableArrayList(Client.network.getArrayString("choice_pr")));
        box_project.setItems(FXCollections.observableArrayList(Client.network.getArrayString("choice_pr")));


    }

    public void Print() throws IOException, ClassNotFoundException {


        ObservableList<Colleague> list1 = FXCollections.observableArrayList(Client.network.getCol("get_col", box_project.getValue().trim()));
        ObservableList<Requirement> observableList3 = FXCollections.observableArrayList(Client.network.getArrayList("view"));
        ObservableList<Customer> list2 = FXCollections.observableArrayList(Client.network.getCust("get_cust", box_project.getValue().trim()));


        writeToTextFile(box_project.getValue(), "project_info.txt", observableList3, list2, list1);


    }

    private static void writeToTextFile(String pr, String filename, ObservableList<Requirement> students, ObservableList<Customer> cust,
                                        ObservableList<Colleague> col)
            throws IOException {

        FileWriter writer = new FileWriter(filename);
        writer.write("Требования проекта:" + pr + "\n");
        for (Requirement student : students) {
            writer.write(student.getType() + "," + student.getInfo() +
                    "," + student.getStartTime() + "," + student.getEndTime() + "\n");
        }
        writer.write("Команда проекта:" + "\n");
        for (Colleague student : col) {
            writer.write(student.getName() + "," + student.getSecondName() + "," + student.getPosition() + "\n");
        }
        writer.write("Заказчики проекта:" + "\n");
        for (Customer student : cust) {
            writer.write(student.getCust_name() + "\n");
        }
        writer.close();
    }


    public void Add_req() throws IOException {


        Client.network.sendInfo("add", id.getText().trim(), type.getText().trim(), info.getText().trim(), start.getText().trim(), end.getText().trim(), box_id_pr.getValue().trim());
        id.setText("");
        type.setText("");
        info.setText("");
        start.setText("");
        end.setText("");


    }

    public void Add_user() throws IOException {


        Client.network.sendUser("add_user", txt_id.getText().trim(), txt_name.getText().trim(), txt_surname.getText().trim(), txt_status.getText().trim());
        txt_id.setText("");
        txt_name.setText("");
        txt_surname.setText("");
        txt_status.setText("");


    }

    public void go_back(ActionEvent event) throws IOException {


        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LogIn.fxml")));

        parent.getChildren().setAll(pane);

    }

    public void Show_user() throws IOException, ClassNotFoundException {

        ObservableList<User> observableList = FXCollections.observableArrayList(Client.network.getArrayUser("viewUser"));
        user.setItems(observableList);
        //названия как в КЛАССЕ
        user.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("idUser"));
        user.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("login"));
        user.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("password"));
        user.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("status"));


    }

    public void Show_req() throws IOException, ClassNotFoundException {


        ObservableList<Requirement> observableList = FXCollections.observableArrayList(Client.network.getArrayList("view"));
        tab_req.setItems(observableList);
        //названия как в КЛАССЕ
        tab_req.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("idRequirement"));
        tab_req.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("type"));
        tab_req.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("Info"));
        tab_req.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("StartTime"));
        tab_req.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("EndTime"));
        tab_req.getColumns().get(5).setCellValueFactory(new PropertyValueFactory("fk_id_project"));


        FilteredList<Requirement> filteredData = new FilteredList<>(observableList, p -> true);


        txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getType().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (person.getInfo().toLowerCase().contains(lowerCaseFilter)) {
                    return true;

                } else if (person.getFk_id_project().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });


        SortedList<Requirement> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tab_req.comparatorProperty());
        tab_req.setItems(sortedData);

    }

    public void Delete_req() throws IOException, ClassNotFoundException {

        try {
            String flagDelete = Client.network.delete("delete", del_info.getText().trim());
            if (flagDelete.equals("false")) {
                JOptionPane.showMessageDialog(null, "Ничего нет!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Show_req();
    }

    public void DeleteUser() throws IOException, ClassNotFoundException {

        try {
            String flagDelete = Client.network.deleteUser("deleteUser", txt_id.getText().trim());
            if (flagDelete.equals("false")) {
                JOptionPane.showMessageDialog(null, "Ничего нет!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Show_user();
    }

    @FXML
    void getSelected_user(MouseEvent event) {
        index = user.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
       /* id.setText(col_id.getCellData(index));
        type.setText(col_type.getCellData(index));*/
        txt_id.setText(col_id_user.getCellData(index).toString());
      /*  start.setText(col_start.getCellData(index));
        end.setText(col_end.getCellData(index));
        fk_id_pr.setText(col_fk_id.getCellData(index).toString());*/
    }

    @FXML
    void getSelected(MouseEvent event) {
        index = tab_req.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
       /* id.setText(col_id.getCellData(index));
        type.setText(col_type.getCellData(index));*/
        del_info.setText(col_id.getCellData(index).toString());
      /*  start.setText(col_start.getCellData(index));
        end.setText(col_end.getCellData(index));
        fk_id_pr.setText(col_fk_id.getCellData(index).toString());*/
    }

    public void Edit() {


        String flagEdit = Client.network.edit("edit", id_field.getText().trim(), txt_old_id.getText().trim(), txt_type.getText().trim(), txt_info.getText().trim(), txt_start.getText().trim(), txt_end.getText().trim(), txt_fk_id_pr.getText().trim());

        txt_end.setText("");
        txt_start.setText("");
        txt_type.setText("");
        txt_info.setText("");
        txt_fk_id_pr.setText("");
        // Show_req();
        if (flagEdit.equals("false")) {
            JOptionPane.showMessageDialog(null, "Ничего не найдено!");
        }


    }
}