/** PROPERTIES ***/
Property Name(txt);
Property Represses(txt);
Property Direction(txt);

/** PART TYPES ***/
PartType Promoter(Name, Direction);
PartType RBS (Name);
PartType Repressor(Name, Represses, Direction);
PartType Reporter(Name, Direction);
PartType Terminator(Name);


//***************************
// Define the Design Space
//***************************

/*** Inducible Promoters ***/
Promoter pBad_forward(
    .Name("pBad"),
    .Direction("forward"));
Promoter pBad_backward(
    .Name("pBad"),
    .Direction("backward"));

Promoter pDntR_forward(
    .Name("pDntR"),
    .Direction("forward"));
Promoter pDntR_backward(
    .Name("pDntR"),
    .Direction("backward"));

Promoter pLux_forward(
    .Name("pLux"),
    .Direction("forward"));
Promoter pLux_backward(
    .Name("pLux"),
    .Direction("backward"));
    
Promoter pTetR_forward(
    .Name("pTetR"),
    .Direction("forward"));
Promoter pTetR_backward(
    .Name("pTetR"),
    .Direction("backward"));
 
Promoter pCI_forward(
    .Name("pCI"),
    .Direction("forward"));
Promoter pCI_backward(
    .Name("pCI"),
    .Direction("backward"));


/*** Repressors ***/
Repressor cI_forward(
    .Name("BBa_C0051"),
    .Represses("pCI"),
	.Direction("forward"));
Repressor cI_backward(
    .Name("BBa_C0051"),
    .Represses("pCI"),
	.Direction("backward"));
	
Repressor LuxR_forward(
	.Name("LuxR"),
	.Represses("pLux"),
	.Direction("forward"));
Repressor LuxR_backward(
	.Name("LuxR"),
	.Represses("pLux"),
	.Direction("backward"));

Repressor TetR_forward(
	.Name("TetR"),
	.Represses("pTet"),
	.Direction("forward"));
Repressor TetR_backward(
	.Name("TetR"),
	.Represses("pTet"),
	.Direction("backward"));

/*** Ribosome Binding Sites ***/
RBS rbs61100("J61100");
RBS rbs61101("J61101");
RBS rbs61102("J61102");
RBS rbs61103("J61103");
RBS rbs61104("J61104");

/*** Reporters ***/
Reporter GFP(.Name("GFP"));
Reporter RFP(.Name("GFP"));
Reporter YFP(.Name("YFP"));

/*** Terminators ***/
Terminator T1(.Name("T1"));
Terminator T7(.Name("T7"));
Terminator BBa_B0010(.Name("BBa_B0010"));
