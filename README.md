# hlaGenotypeEvaluator
 - The software compares test HLA genotypes against reference HLA genotypes

# Installation and Execution:
 - Install JDK (written for 1.8)
 - Download Maven (https://maven.apache.org/download.cgi)
 - Install Maven (https://maven.apache.org/install.html, or useful instruction for Windows: https://www.mkyong.com/maven/how-to-install-maven-in-windows/) 
 - Confirm correct installation by: mvn -version
 - It is important to set JAVA_HOME and PATH environments correctly.
 
 - Install Git (https://git-scm.com/downloads)
 - Open terminal (use Git Bash terminal for Windows)
 - Change directory where haplObserve should be cloned, e.g., "cd" will change to your home directory
 - Clone the repository: git clone https://github.com/IHIW/hlaGenotypeEvaluator.git
 - When hlaGenotypeEvaluator is cloned in home (~): cd hlaGenotypeEvaluator (go inside of hlaGenotypeEvaluator directory)
 - From the root of the hlaGenotypeEvaluator cloned (local) repository: mvn clean install
 
 # Script:
 1. driverForGenerateCompareResultsTable.sh &lt;referenceFile> &lt;resultFile> &lt;outputFileName>
 - This script takes csv files as input files, and generates csv output file
 - The first argument should be a file containing reference HLA genotypes (CSV file format)
 - The second argument should be a file that contains results to be evaluated (CSV file format)
 - These files should be in the same format. The first column indicates "Sample ID", and the second column shows "GL String". These files should contain header in the first line
 - The third argument should be provided to specify output file name. Date and ".csv" extension is added by the software
 
 
 2. driverForRunValidation.sh &lt;baseDirectory>
 - Input files can be Histoimmunogenetics Markup Language (HML: https://bioinformatics.bethematchclinical.org/hla-resources/hml/) or csv file format. See above description about csv file format. The file extension of HML can be either ".xml" or ".hml". 
 - The HML report output can be generated using commercially available NGS HLA genotyping software, such as MiaFora (Immucor), TypeStream Visual (One Lambda) or HLA Twin (Omixon)
 - This script takes “&lt;baseDirectory>/” as an argument. The &lt;baseDirectory> name can be anything, such as validation.
 - requires the following directory and file structures:
 - “&lt;baseDirectory>/ref/XXX.xml”, “&lt;baseDirectory>/ref/XXX.hml” or “&lt;baseDirectory>/ref/XXX.csv”. Input reference file should be stored in “ref” directory, and "ref" directory name must be used. 
 - “&lt;baseDirectory>/test/YYY.xml”, “&lt;baseDirectory>/test/YYY.hml” or “&lt;baseDirectory>/test/YYY.csv”. Input test file should be stored in “test” directory, and "test" directory name must be used.
 - The output file is generated in “&lt;baseDirectory>/TestResult_today.csv". The file name will have today's date.
 
 # Scoring description in Results file
 - Identical: HLA genotypes are exactly identical
 - Concordance: Both Result and Ref are concordant at least by two field assessment
 - AmbResultConcordant: Ambiguity reported in the Result but not in the Reference
 - AmbRefConcordant: Ambiguity reported in the Reference
 - AmbRefAmbResultConcordant: Ambiguity reported in the Reference and result
 - UnresolvedNullAmbResultConcordant: Concordant, but Null allele was found in the result ambiguity string
 - Discordant: Indicates both alleles do not match at all
