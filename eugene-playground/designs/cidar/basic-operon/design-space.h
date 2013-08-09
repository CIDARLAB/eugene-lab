/*
 * PROPERTIES 
 */
Property Name(txt);
Property Strength(num);
Property UUID(txt);
Property Type(txt);
Property Color(num);

/*
 * PART TYPES 
 */
Part Promoter(UUID, Name, Strength, Type, Color);
Part RBS(UUID, Name, Strength, Type, Color);
Part Term(UUID, Name, Type, Color);
Part Spacer(UUID, Name, Type, Color);
Part CDS(UUID, Name, Type, Color);

/*
 * PARTS 
 */

/* PROMOTERS */
Promoter T7("0000", "T7", 0.38, "p", 5);
Promoter P6("0001", "P6", 0.162, "p", 4);
Promoter P4("0002", "P4", 0.089, "p", 3);
//Promoter P5("0003", "P5", 0.056, "p", 2);
//Promoter P2("0004", "P2", 0.019, "p", 1);

/* RBS 0 value from Data set 1 */
RBS R0("0005", "RBS0", 42010.79, "r", 3);
RBS R1("0006", "RBS1", 39802.15, "r", 1);
RBS R2("0007", "RBS2", 52612.24, "r", 5);
//RBS R3("0008", "RBS3", 52612.24, "r", 5); // Strange: Str(RBS2) == Str(RBS3)?
//RBS R4("0009", "RBS4", 52612.24, "r", 5); // Strange: Str(RBS2) == Str(RBS4)?
//RBS R5("000a", "RBS5", 52612.24, "r", 5); // Strange: Str(RBS2) == Str(RBS5)?
//RBS R6("000b", "RBS6", 52612.24, "r", 5); // Strange: Str(RBS2) == Str(RBS6)?
//RBS OriginalRBS("000c", "OriginalRBS", 0, "r", 0);

/* Coding Sequences */
CDS H("000c", "H", "c", 2);
CDS D("000d", "D", "c", 4);
CDS K("000e", "K", "c", 6);
CDS Y("000f", "Y", "c", 8);

/* Terminators */
Term OriginalTerminator("0010", "OriginalTerminator", "t", 6);
Term T23("0011", "T23", "t", 6);
Term TB("0012", "TB", "t", 6);

/* Spacers */
Spacer S1("0013", "S1", "s", 0);
Spacer OriginalSpacer("0013", "OriginalSpacer", "s", 0);


// reverse parts

//Promoter T7r("0000", "T7", 0.38, "<p", 5);
//Promoter P6r("0001", "P6", 0.162, "<p", 4);
//Promoter P4r("0002", "P4", 0.089, "<p", 3);
//Promoter P5r("0003", "P5", 0.056, "<p", 2);
//Promoter P2r("0004", "P2", 0.019, "<p", 1);


//CDS Hr("000c", "H", "<c", 2);
//CDS Dr("000d", "D", "<c", 4);
//CDS Kr("000e", "K", "<c", 6);
//CDS Yr("000f", "Y", "<c", 8);

// PARTS library end 
