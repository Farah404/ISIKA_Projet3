package fr.isika.cda17.project3.model.serviceManagement;

public enum PersonalAssistanceType {

    MEDICAL("Médicale"), GROCERY("Courses");

    private String label;

    private PersonalAssistanceType(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }
}
