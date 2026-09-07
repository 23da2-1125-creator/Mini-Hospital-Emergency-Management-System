Mini Hospital Emergency Management System
Project Description
We have the (Mini) Hospital Emergency Management System as a Java application for CIT300, I consider simulating hospital workflows with core data structures. A Binary Search Tree is used in patient records for efficient search, a Queue is employed with emergency cases for a fair processing, recency is used with treatments in a Stack, and chronological order is followed in visit history with a Singly Linked List.

The project demonstrates the practical use of four important data structures:

Binary Search Tree (BST)
Queue
Stack
Singly Linked List
Objectives
The main objectives of this project are:

To register and manage patient records.
To search and delete patient records.
To manage emergency patients using a Queue.
To maintain completed treatment records using a Stack.
To maintain patient visit history using a Singly Linked List.
To understand how different data structures can be applied to a real-world hospital management system.
Data Structures Used
1. Binary Search Tree (BST) – Patient Records
A Binary Search Tree is used to store patient records using the Patient ID as the key.

The following operations are implemented:

Insert a new patient
Search for a patient using Patient ID
Delete a patient
Display patients using in-order traversal
Each patient record contains:

Patient ID
Patient Name
Age
Contact Number
Medical Condition
The in-order traversal displays patient records in ascending order of Patient ID.

2. Queue – Emergency Patient Management
A Queue is used to manage patients waiting for emergency treatment.

The following operations are implemented:

Enqueue a patient
Dequeue the next patient for treatment
Display all patients currently waiting
Handle an empty queue
The Queue follows the FIFO (First-In, First-Out) principle. Therefore, the patient who arrives first is treated first.

3. Stack – Treatment History
A Stack is used to store completed treatment records.

The following operations are implemented:

Push a completed treatment record
Pop the most recently completed treatment record
Display treatment records
Handle an empty stack
The Stack follows the LIFO (Last-In, First-Out) principle. Therefore, the most recently completed treatment is removed first.

4. Singly Linked List – Patient Visit History
A Singly Linked List is used to maintain previous hospital visits of patients.

The following operations are implemented:

Add a new visit
Remove a visit
Search for a visit
Display patient visit history
Each visit may contain:

Visit ID
Visit Date
Doctor Name
Diagnosis
Treatment
System Features
The system provides the following main features:

Patient registration
Patient searching
Patient deletion
Patient record display
Emergency patient queue management
Treatment history management
Patient visit history management
Search and deletion of visits
Handling of empty data structures
Menu-based user interaction
Technologies Used
Java
Eclipse IDE
Git
GitHub
Author
SLTC INDEX NO : 23DA2-1125 A.M.MOHAMED RINAS

Project Structure
MiniHospitalEmergencySystem
│
├── src
│   └── hospital
│       ├── Main.java
│       │
│       ├── bst
│       │   ├── Patient.java
│       │   └── PatientBST.java
│       │
│       ├── queue
│       │   └── EmergencyQueue.java
│       │
│       ├── stack
│       │   └── TreatmentStack.java
│       │
│       └── linkedlist
│           ├── Visit.java
│           └── VisitHistory.java
│
└── README.md
