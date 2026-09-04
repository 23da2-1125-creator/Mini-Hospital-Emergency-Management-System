package hospital.bst;

import hospital.linkedlist.VisitHistory;

public class Patient {

    int patientId;
    String patientName;
    int age;
    String contactNumber;
    String medicalCondition;
    VisitHistory visitHistory;

    Patient left;
    Patient right;

    public Patient(int patientId, String patientName, int age,
                   String contactNumber, String medicalCondition) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitHistory();

        left = null;
        right = null;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public VisitHistory getVisitHistory() {
        return visitHistory;
    }

    public void displayPatient() {

        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Medical Condition: " + medicalCondition);
        System.out.println("-----------------------------");
    }
}
