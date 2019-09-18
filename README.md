# hlaGenotypeEvaluator
 - The software compares test HLA genotypes against reference HLA genotypes
 - hlaGenotypeEvaluator assigned a score for each allele tested
 
# Prerequisite:
 - For Windows computers, we recommend installing the Git Bash terminal (https://git-scm.com/download/win). The Git Bash terminal allows HaplObserve to be run the same way as in Linux and Mac terminals
  
 - Download and Install Java SE Development Kit (JDK - 1.8 or newer)
 

# Input files
 1. Input files can be Histoimmunogenetics Markup Language (HML: https://bioinformatics.bethematchclinical.org/hla-resources/hml/) or csv file format.
 - The file extension of HML can be either ".xml" or ".hml".
 - The HML report can be generated using commercially available NGS HLA genotyping software, such as MiaFora (Immucor), TypeStream Visual (One Lambda) or HLA Twin (Omixon)
 - The reference HML contains "reference" report, and test HML includes test report
 - The software takes &lt;baseDirectory> as an argument. The &lt;baseDirectory> name can be anything, such as validation, but do not use space in &lt;baseDirectory> name.
 - HML files must be stored in "ref" and "test" directories.The software requires the following directory and file structures:
 - “&lt;baseDirectory>/ref/XXX.xml”, “&lt;baseDirectory>/ref/XXX.hml” or “&lt;baseDirectory>/ref/XXX.csv”
 - Input reference file (XXX) should be stored in “ref” directory, and "ref" directory name must be used.
 - “&lt;baseDirectory>/test/YYY.xml”, “&lt;baseDirectory>/test/YYY.hml” or “&lt;baseDirectory>/test/YYY.csv”
 - Input test file (YYY) should be stored in “test” directory, and "test" directory name must be used.
 - Only one HML file should be stored in each "ref" and "test" directories.
 - The software can be executed as follows:
 - java -jar  hlaGenotypeEvaluator-0.0.1-SNAPSHOT-jar-with-dependencies.jar &lt;baseDirectory>
 - The output file is generated in “<baseDirectory>/TestResult_today.csv". The file name will have today's date.
 
 
 
 2. This software takes csv files as input files, and generates csv output file as follows:
 - The first argument should be a file containing reference HLA genotypes (CSV file format)
 - The second argument should be a file that contains test HLA genotypes to be evaluated (CSV file format)
 - These files should be in the same format. The first column indicates "Sample ID", and the second column shows "GL String". These files should contain header in the first line
 - The third argument should be provided to specify output file name. Date and ".csv" extension is added by the software
 - The software can be executed as follows:
 - java -jar  hlaGenotypeEvaluator-0.0.1-SNAPSHOT-jar-with-dependencies.jar reference.csv test.csv testResult
 


 # Scoring description in Results file
 - the software generates a result csv file
 - Results consisted of a column for each allele and locus with 3 rows per sample.
 - The first row represents the "Reference" HLA genotypes.
 - The second row shows "Test" HLA genotypes.
 - The third row contains "Score" for the comparison between the reference genotypes and the test genotypes for each locus
 - The "Score" includes the following wording
 - Identical: HLA genotypes are exactly identical
 - Concordance: Both Test and Ref are concordant at least by two field assessment
 - AmbResultConcordant: Ambiguity reported in the Test but not in the Reference
 - AmbRefConcordant: Ambiguity reported in the Reference
 - AmbRefAmbResultConcordant: Ambiguity reported in the Reference and Test
 - UnresolvedNullAmbResultConcordant: Concordant, but Null allele was found in the Test ambiguity string
 - Discordant: Indicates both alleles do not match at all
