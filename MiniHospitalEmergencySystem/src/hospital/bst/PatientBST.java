package hospital.bst;

public class PatientBST {

    public Patient root;

    public PatientBST() {
        root = null;
        
    }

    public boolean isEmpty() {
        return root == null;
    }
    
    
  //Insert operation
    
    public void insert(Patient newPatient) {

        if (root == null) {
            root = newPatient;
            return;
        }

        
        Patient current = root;

        while (true) {

            if (newPatient.patientId < current.patientId) {

                if (current.left == null) {
                    current.left = newPatient;
                    return;
                }

                current = current.left;

            } else {

                if (current.right == null) {
                    current.right = newPatient;
                    return;
                }

                current = current.right;
            }
        }
    }
    
    
    //Search operation
    
    public Patient search(int patientId) {

        Patient current = root;

        while (current != null) {

            if (patientId == current.patientId) {
                return current;
            }

            if (patientId < current.patientId) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }
    

 
    
    
    //Delete operation
    
    public void delete(int patientId) {
        root = deleteNode(root, patientId);
    }

    
    //deleteNode
    
    private Patient deleteNode(Patient current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId < current.patientId) {

            current.left = deleteNode(current.left, patientId);

        } else if (patientId > current.patientId) {

            current.right = deleteNode(current.right, patientId);

        } else {

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            Patient successor = findMinimum(current.right);

            current.patientId = successor.patientId;
            current.patientName = successor.patientName;
            current.age = successor.age;
            current.contactNumber = successor.contactNumber;
            current.medicalCondition = successor.medicalCondition;
            current.visitHistory = successor.visitHistory;

            current.right = deleteNode(current.right, successor.patientId);
        }

        return current;
    }
    
    //findMinimum
    
    private Patient findMinimum(Patient current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
    
    
   //In-order traversal
    
    public void inOrder(Patient current) {

        if (current != null) {

            inOrder(current.left);

            current.displayPatient();

            inOrder(current.right);
        }
        
    }
}
