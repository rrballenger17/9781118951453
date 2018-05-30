class SmallerTax extends Tax{
	// Constructor
	SmallerTax (double gi, String st, int depen){
		super(gi,st,depen);
		// Adding code specific to descendant’s constructor
		System.out.println("Applying special tax rates for my friends.");
	}

}