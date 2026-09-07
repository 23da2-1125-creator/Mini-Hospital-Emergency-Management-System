package hospital; 
 
import java.util.Scanner; 
 
import hospital.bst.Patient; 
import hospital.bst.PatientBST; 
import hospital.linkedlist.Visit; 
import hospital.linkedlist.VisitHistory; 
import hospital.queue.EmergencyQueue; 
import hospital.stack.TreatmentStack; 
 
public class Main { 
 
   
    // SYSTEM VARIABLES / DATA STRUCTURES
   
    private static Scanner scanner = new Scanner(System.in); 
    private static PatientBST patientBST = new PatientBST(); 
    private static EmergencyQueue emergencyQueue = new EmergencyQueue(50); 
    private static TreatmentStack treatmentStack = new TreatmentStack(50); 
 
    public static void main(String[] args) { 
 
        
        // MAIN MENU
     
        int choice; 
 
        do { 
            displayMainMenu(); 
            choice = readInt("Enter choice: "); 
 
            switch (choice) { 
                case 1: 
                    patientRecordsMenu(); 
                    break; 
                case 2: 
                    emergencyQueueMenu(); 
                    break; 
                case 3: 
                    treatmentHistoryMenu(); 
                    break; 
                case 4: 
                    visitHistoryMenu(); 
                    break; 
                case 5: 
                    System.out.println("Exiting system. Thank you."); 
                    break; 
                default: 
                    System.out.println("Invalid choice. Please try again."); 
            } 
 
        } while (choice != 5); 
 
        scanner.close(); 
    } 
 
    
    // DISPLAY MAIN MENU
    
    private static void displayMainMenu() { 
 
        System.out.println(); 
        System.out.println("MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM"); 
        System.out.println("1. Patient Records"); 
        System.out.println("2. Emergency Patient Queue"); 
        System.out.println("3. Treatment History"); 
        System.out.println("4. Patient Visit History"); 
        System.out.println("5. Exit"); 
    } 
 
   
    //PATIENT RECORDS - BINARY SEARCH TREE (BST)
  
    private static void patientRecordsMenu() { 
 
        int choice; 
 
        do { 
            System.out.println(); 
            System.out.println("PATIENT RECORDS - BST"); 
            System.out.println("1. Register/Add Patient"); 
            System.out.println("2. Search Patient"); 
            System.out.println("3. Delete Patient"); 
            System.out.println("4. Display Patients In-Order"); 
            System.out.println("5. Back to Main Menu"); 
 
            choice = readInt("Enter choice: "); 
 
            switch (choice) { 
                case 1: 
                    registerPatient(); 
                    break; 
                case 2: 
                    searchPatient(); 
                    break; 
                case 3: 
                    deletePatient(); 
                    break; 
                case 4: 
                    displayPatients(); 
                    break; 
                case 5: 
                    break; 
                default: 
                    System.out.println("Invalid choice. Please try again."); 
            } 
 
        } while (choice != 5); 
    } 
 
   
    //EMERGENCY PATIENT QUEUE - FIFO

    private static void emergencyQueueMenu() { 
 
        int choice; 
 
        do { 
            System.out.println(); 
            System.out.println("EMERGENCY PATIENT QUEUE - FIFO"); 
            System.out.println("1. Add Patient to Queue"); 
            System.out.println("2. Display Waiting Patients"); 
            System.out.println("3. Dequeue Patient for Treatment"); 
            System.out.println("4. Back to Main Menu"); 
 
            choice = readInt("Enter choice: "); 
 
            switch (choice) { 
                case 1: 
                    addPatientToQueue(); 
                    break; 
                case 2: 
                    emergencyQueue.displayQueue(); 
                    break; 
                case 3: 
                    dequeuePatientForTreatment(); 
                    break; 
                case 4: 
                    break; 
                default: 
                    System.out.println("Invalid choice. Please try again."); 
            } 
 
        } while (choice != 4); 
    } 
 
    
    //TREATMENT HISTORY - STACK (LIFO)
   
    private static void treatmentHistoryMenu() { 
 
        int choice; 
 
        do { 
            System.out.println(); 
            System.out.println("TREATMENT HISTORY - STACK"); 
            System.out.println("1. Add Completed Treatment"); 
            System.out.println("2. Pop Latest Treatment"); 
            System.out.println("3. Display Treatment History"); 
            System.out.println("4. Back to Main Menu"); 
 
            choice = readInt("Enter choice: "); 
 
            switch (choice) { 
                case 1: 
                    addCompletedTreatment(); 
                    break; 
                case 2: 
                    popLatestTreatment(); 
                    break; 
                case 3: 
                    treatmentStack.displayStack(); 
                    break; 
                case 4: 
                    break; 
                default: 
                    System.out.println("Invalid choice. Please try again."); 
            } 
 
        } while (choice != 4); 
    } 
 
   
    //PATIENT VISIT HISTORY - SINGLY LINKED LIST
 
    private static void visitHistoryMenu() { 
 
        Patient patient = selectPatient(); 
 
        if (patient == null) { 
            return; 
        } 
 
        int choice; 
 
        do { 
            System.out.println(); 
            System.out.println("VISIT HISTORY - SINGLY LINKED LIST"); 
            System.out.println("Selected Patient: " + patient.getPatientId() + " - " + patient.getPatientName()); 
            System.out.println("1. Add New Visit"); 
            System.out.println("2. Remove Visit"); 
            System.out.println("3. Search Visit"); 
            System.out.println("4. Display Patient Visit History"); 
            System.out.println("5. Back to Main Menu"); 
 
            choice = readInt("Enter choice: "); 
 
            switch (choice) { 
                case 1: 
                    addVisit(patient); 
                    break; 
                case 2: 
                    removeVisit(patient); 
                    break; 
                case 3: 
                    searchVisit(patient); 
                    break; 
                case 4: 
                    patient.getVisitHistory().displayHistory(); 
                    break; 
                case 5: 
                    break; 
                default: 
                    System.out.println("Invalid choice. Please try again."); 
            } 
 
        } while (choice != 5); 
    } 
 
    
    //ADD / REGISTER PATIENT

    private static void registerPatient() { 
 
        int patientId = readInt("Enter Patient ID: "); 
 
        if (patientBST.search(patientId) != null) { 
            System.out.println("A patient with this ID already exists."); 
            return; 
        } 
 
        String patientName = readLine("Enter Patient Name: "); 
        int age = readInt("Enter Age: "); 
        String contactNumber = readLine("Enter Contact Number: "); 
        String medicalCondition = readLine("Enter Medical Condition: "); 
 
        Patient patient = new Patient(patientId, patientName, age, contactNumber, medicalCondition); 
 
        patientBST.insert(patient); 
        System.out.println("Patient registered successfully."); 
    } 
 
   
    //SEARCH PATIENT
 
    private static void searchPatient() { 
 
        Patient patient = selectPatient(); 
 
        if (patient != null) { 
            System.out.println("Patient found:"); 
            patient.displayPatient(); 
        } 
    } 
 
  
    //DELETE PATIENT
    
    private static void deletePatient() { 
 
        int patientId = readInt("Enter Patient ID to delete: "); 
 
        Patient patient = patientBST.search(patientId); 
 
        if (patient == null) { 
            System.out.println("Patient not found."); 
            return; 
        } 
 
        patientBST.delete(patientId); 
        System.out.println("Patient deleted successfully."); 
    } 
 
    
    //IN-ORDER TRAVERSAL
   
    private static void displayPatients() { 
 
        if (patientBST.isEmpty()) { 
            System.out.println("No patient records available."); 
            return; 
        } 
 
        System.out.println(); 
        System.out.println("PATIENTS IN ASCENDING ORDER OF ID"); 
        patientBST.inOrder(patientBST.root); 
    } 
 

    //ENQUEUE PATIENT
    
    private static void addPatientToQueue() { 
 
        Patient patient = selectPatient(); 
 
        if (patient != null) { 
            emergencyQueue.enqueue(patient); 
        } 
    } 
 
   
    //DEQUEUE PATIENT
   
    private static void dequeuePatientForTreatment() { 
 
        Patient patient = emergencyQueue.dequeue(); 
 
        if (patient != null) { 
            System.out.println("Next patient sent for treatment:"); 
            patient.displayPatient(); 
        } 
    } 
 

    //PUSH COMPLETED TREATMENT

    private static void addCompletedTreatment() { 
 
        Patient patient = selectPatient(); 
 
        if (patient == null) { 
            return; 
        } 
 
        String treatmentDetails = readLine("Enter completed treatment details: "); 
 
        String record = "Patient ID: " + patient.getPatientId() 
                + ", Name: " + patient.getPatientName() 
                + ", Condition: " + patient.getMedicalCondition() 
                + ", Treatment: " + treatmentDetails; 
 
        treatmentStack.push(record); 
    } 
 
  
    //POP LATEST TREATMENT

    private static void popLatestTreatment() { 
 
        String treatment = treatmentStack.pop(); 
 
        if (treatment != null) { 
            System.out.println("Removed latest treatment:"); 
            System.out.println(treatment); 
        } 
    } 
 
    
    //ADD VISIT
  
    private static void addVisit(Patient patient) { 
 
        String visitId = readLine("Enter Visit ID: "); 
 
        if (patient.getVisitHistory().searchVisit(visitId) != null) { 
            System.out.println("A visit with this ID already exists for this patient."); 
            return; 
        } 
 
        String visitDate = readLine("Enter Visit Date: "); 
        String doctorName = readLine("Enter Doctor Name: "); 
        String diagnosis = readLine("Enter Diagnosis: "); 
        String treatment = readLine("Enter Treatment: "); 
 
        Visit visit = new Visit(visitId, visitDate, doctorName, diagnosis, treatment); 
 
        patient.getVisitHistory().addVisit(visit); 
    } 
 
   
    //REMOVE VISIT
    
    private static void removeVisit(Patient patient) { 
 
        String visitId = readLine("Enter Visit ID to remove: "); 
 
        patient.getVisitHistory().removeVisit(visitId); 
    } 
 
   
    //SEARCH VISIT

    private static void searchVisit(Patient patient) { 
 
        String visitId = readLine("Enter Visit ID to search: "); 
 
        VisitHistory history = patient.getVisitHistory(); 
        Visit visit = history.searchVisit(visitId); 
 
        if (visit == null) { 
            System.out.println("Visit not found."); 
        } else { 
            System.out.println("Visit found:"); 
            visit.displayVisit(); 
        } 
    } 
 
 
    // PATIENT SELECTION / BST SEARCH SUPPORT

    private static Patient selectPatient() { 
 
        int patientId = readInt("Enter Patient ID: "); 
 
        Patient patient = patientBST.search(patientId); 
 
        if (patient == null) { 
            System.out.println("Patient not found. Register the patient first."); 
        } 
 
        return patient; 
    } 
 

    // INPUT VALIDATION - INTEGER INPUT
 
    private static int readInt(String message) { 
 
        while (true) { 
            System.out.print(message); 
 
            if (scanner.hasNextInt()) { 
                int value = scanner.nextInt(); 
                scanner.nextLine(); 
                return value; 
            } 
 
            System.out.println("Invalid number. Please enter digits only."); 
            scanner.nextLine(); 
        } 
    } 
 

    // INPUT HANDLING - STRING INPUT

    private static String readLine(String message) { 
 
        System.out.print(message); 
        return scanner.nextLine(); 
    } 
}