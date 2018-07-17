# hlaGenotypeEvaluator
<<<<<<< HEAD

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
 - From the root of the haplObserve cloned (local) repository: mvn clean install
 
 # Script:
 1. driverForGenerateCompareResultsTable.sh &lt;referenceFile> &lt;resultFile> &lt;outputFileName>
 - The first argument should be a file containing reference HLA genotypes (CSV file format)
 - The second argument should be a file that contains results to be evaluated (CSV file format)
 - These files should be in the same format. The first column indicates "Sample ID", and the second column shows "GL String". These files should contain header in the first line.
 - The third argument should be provided to specify output file name. Date and ".csv" extension is added by the software
 
 
