# Java UDF for Athena Spark
This is a sample User Defined Function (UDF) in Java that converts a month number to a month name. The purpose of this UDF to demonstrate UDF functionality in Athena Spark.

## Prerequisite
You need a Spark session to test the functionality of the UDF. Here, we will use Athena Spark. Please refer to the [Athena Spark getting started guide](https://docs.aws.amazon.com/athena/latest/ug/notebooks-spark-getting-started.html) to set up Athena Spark.

## Build and package
To build the JAR file containing the UDF:
1. Clone the repository
```
git clone https://github.com/aws-samples/athena-samples.git
```
2. Change to the java-udf directory
```
cd athena-samples/examples/spark-udfs/java-udf/udf/
```

3. Build the JAR file with maven:
```
mvn package
```
This will generate a JAR file target/java-udf-demo-1.0.jar.

## Copy to S3
Copy the generated JAR file to an S3 bucket to be used later in Athena Spark:
```
aws s3 cp target/java-udf-demo-1.0 s3://<your-bucket>/spark/udf/java/
```
Replace <your-bucket> with the name of your S3 bucket.
## Usage Demo
We can demonstrate the functionality of this UDF in Athena Spark.

First, execute the following Spark SQL code in a notebook cell to create a temporary function using the UDF:
```sql
%%sql
CREATE OR REPLACE TEMPORARY FUNCTION 
month_number_to_name as 'com.example.MonthNumbertoNameUDF'
using jar "s3a://<your-bucket>/spark/udf/java/java-udf-demo-1.0.jar";
```

Then test it:
```sql
%%sql
SELECT month_number_to_name(1)
```
Output should be:
```
January
```
## License
This library is licensed under the MIT-0 License. See the LICENSE file.This project is licensed under the MIT License - see the LICENSE file for details.