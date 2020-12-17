package model;

import java.util.ArrayList;



public class ModelView {
    private ArrayList<String> labelsTexts;
    private ArrayList<String> labelsRegisterTexts;
    private ArrayList<String> buttonGroupText;
    private String btnLoginText;
    private int totalTextFields = 2;
    private String signUpText = "Registrarse";

 

    public ModelView() {
        addLabelsTexts();
        addLabelsRegisterTexts();
        addRadioGroupText();
        btnLoginText = "Iniciar sesión";
    }

 

    public int getTotalTextFields() {
        return totalTextFields;
    }

 

    public void setTotalTextFields(int totalTextFields) {
        this.totalTextFields = totalTextFields;
    }

 

    /**
     * Método que rellena el ArrayList labelsTexts.
     */
    private void addLabelsTexts() {
        labelsTexts = new ArrayList<String>();
        labelsTexts.add("Dirección de email");
        labelsTexts.add("Contraseña");
        labelsTexts.add("Regístrarse");
    }
    /**
     * Método que rellena el ArrayList de labels de la clase RegisterView.
     */
    private void addLabelsRegisterTexts() {
        labelsRegisterTexts = new ArrayList<String>();
        labelsRegisterTexts.add("Nombre");
        labelsRegisterTexts.add("Apellidos");
        labelsRegisterTexts.add("Correo electrónico");
        labelsRegisterTexts.add("Contraseña");
        labelsRegisterTexts.add("Edad");
        labelsRegisterTexts.add("Casa en Hogwarts");
        labelsRegisterTexts.add("Profesor");
        labelsRegisterTexts.add("Alumno");
        labelsRegisterTexts.add("Enviar");
        
    }
    private void addRadioGroupText() {
        buttonGroupText = new ArrayList<String>();
        buttonGroupText.add("Profesor");
        buttonGroupText.add("Alumno");
    }

 

    
    public ArrayList<String> getButtonGroupText() {
        return buttonGroupText;
    }

 

    public void setButtonGroupText(ArrayList<String> buttonGroupText) {
        this.buttonGroupText = buttonGroupText;
    }

 

    public ArrayList<String> getLabelsTexts() {
        return labelsTexts;
    }

 

    public void setLabelsTexts(ArrayList<String> labelsTexts) {
        this.labelsTexts = labelsTexts;
    }

 

    public String getBtnLoginText() {
        return btnLoginText;
    }

 

    public void setBtnLoginText(String btnLoginText) {
        this.btnLoginText = btnLoginText;
    }

 

    public String getSignUpText() {
        return signUpText;
    }

 

    public void setSignUpText(String signUpText) {
        this.signUpText = signUpText;
    }

 

    public ArrayList<String> getLabelsRegisterTexts() {
        return labelsRegisterTexts;
    }

 

    public void setLabelsRegisterTexts(ArrayList<String> labelsRegisterTexts) {
        this.labelsRegisterTexts = labelsRegisterTexts;
    }

 

}