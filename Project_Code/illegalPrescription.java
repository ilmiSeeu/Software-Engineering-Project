class illegalPrescription extends Exception {
    illegalPrescription (Doctor l, Drug lm) {
	super("Doctor " + l.getName() + " is not allowed to prescribe " + lm.getName());
    }
}