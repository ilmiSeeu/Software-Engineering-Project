# Software-Engineering-Project
Group members: Ilmi, Yllhanaa, Armend



####Introduction:

This project is a simulation of a doctor's system that allows for the creation and management of patients, doctors, drugs, and prescriptions. The system is implemented in Java and uses various data structures such as ArrayLists to store and manipulate the objects.

####Classes and their functions:

1. Doctor: This class represents a doctor and contains information such as the doctor's name and a list of prescriptions written by the doctor. It also has methods for adding prescriptions and comparing two doctors based on their names.

- Specialist: This class extends the Doctor class and contains an additional field for the specialist's control ID. Idea is that only specialist can write prescriptions, if a non-specialist try to write a prescription to a patient an illegalPrescription will be thrown

2. Drug: This is an abstract class that represents a drug and contains information such as the drug's name, ID, price, and active ingredient. It also has a method to get the type of drug (addictive, narcotic, regular).

- Narcotic and Addictive: These classes extend the Drug class and contain an additional field for strength.

- Regular: This class extends the Drug class.

3. Patient: This class represents a patient and contains information such as the patient's name, birthdate, and ID. It also has a list of prescriptions assigned to the patient.

4. Prescriptions: This is an abstract class that represents a prescription and contains information such as the associated drug, doctor, patient, and remaining reits. It also has a method for using a prescription and decreasing the remaining reits.

- WhitePrescriptions, MilitaryPrescriptions, pPrescription and BluePrescriptions: These classes extend the Prescriptions class and provide implementation for the abstract
