package hospital;

import hospital.bst.Patient;
import hospital.bst.PatientBST;
import hospital.queue.EmergencyQueue;
import hospital.stack.TreatmentStack;
import hospital.linkedlist.Visit;
import hospital.linkedlist.VisitHistory;

public class Main {

    public static void main(String[] args) {

        // Patient BST
        PatientBST bst = new PatientBST();

        Patient p1 = new Patient(101, "Ahmed", 45,
                "0771234567", "Fever");

        Patient p2 = new Patient(102, "Kumar", 32,
                "0772345678", "Headache");

        Patient p3 = new Patient(103, "Fathima", 28,
                "0773456789", "Asthma");


        // Insert patients into BST
        bst.insert(p1);
        bst.insert(p2);
        bst.insert(p3);


        // Emergency Queue
        EmergencyQueue emergencyQueue = new EmergencyQueue(5);


        // Enqueue patients
        emergencyQueue.enqueue(p1);
        emergencyQueue.enqueue(p2);
        emergencyQueue.enqueue(p3);
        


        // Display waiting patients
        System.out.println();
        emergencyQueue.displayQueue();


        // Dequeue next patient
        System.out.println();
        Patient treated = emergencyQueue.dequeue();

        if (treated != null) {

            System.out.println("Patient sent for treatment:");
            treated.displayPatient();
        }


        // Display remaining patients
        System.out.println();
        System.out.println("Remaining Waiting Patients:");
        emergencyQueue.displayQueue();


        // Remove remaining patients
        emergencyQueue.dequeue();
        emergencyQueue.dequeue();


        // Test empty queue
        System.out.println();
        emergencyQueue.dequeue();
        
        
        // Push - add a completed treatment record
        TreatmentStack treatmentStack = new TreatmentStack(5);

        treatmentStack.push("Treatment for P101");
        treatmentStack.push("Treatment for P102");
        treatmentStack.push("Treatment for P103");

        treatmentStack.displayStack();
        
        
        //Pop - remove the most recently completed treatment record
        String treatment = treatmentStack.pop();

        if (treatment != null) {

            System.out.println("Removed: " + treatment);
            
            treatmentStack.displayStack();
            
            
            treatmentStack.pop();
            treatmentStack.pop();
            
            treatmentStack.pop();
            
            
            //Adding a new visit to the patient's history 
            VisitHistory history = new VisitHistory();

            Visit v1 = new Visit(
                    "V001",
                    "2026-08-01",
                    "Dr. Kumar",
                    "Fever",
                    "Medication"
            );

            Visit v2 = new Visit(
                    "V002",
                    "2026-08-15",
                    "Dr. Fathima",
                    "Headache",
                    "Pain relief"
            );

            Visit v3 = new Visit(
                    "V003",
                    "2026-08-25",
                    "Dr. Ahmed",
                    "Asthma",
                    "Inhaler"
            );
            
            
            history.addVisit(v1);
            history.addVisit(v2);
            history.addVisit(v3);
            
            System.out.println("\nPatient Visit History");
            history.displayHistory();
            
            
            
           // Searching for a visit 
            System.out.println("\nSearching for V002:");

            Visit found = history.searchVisit("V002");

            if (found != null) {

                System.out.println("Visit found:");
                found.displayVisit();

            } else {

                System.out.println("Visit not found.");
            }
            
            
            //Removing a visit
            System.out.println("\nRemoving V002:");

            history.removeVisit("V002");
            
            
            System.out.println("\nUpdated Visit History:");
            history.displayHistory();
            
            
            history.removeVisit("V001");
            history.removeVisit("V003");

            history.displayHistory();
            
        }
        
        
      
    }
    
    
}