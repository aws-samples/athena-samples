# Java UDF for Athena Spark
This is a sample User Defned Function (UDF) in Java that converts a month number to a month name. The purpose of this UDF to demonstrate UDF functionality in Athena Spark.

## Prerequisite
You need a Spark session to test the functionality of the UDF. Here, we will use Athena Spark. Please refer to the [Athena Spark getting started guide](https://docs.aws.amazon.com/athena/latest/ug/notebooks-spark-getting-started.html) to set up Athena Spark.

## Build and package
Run the following Maven command to build and package the UDF into a JAR file:
```
mvn package
```

## Copy to S3
Copy the generated JAR file to an S3 bucket to be used later in Athena Spark:
```
aws s3 cp target/java-udf-demo-1.0 s3://<your-bucket>/spark/udf/java/
```
Replace <your-bucket> with the name of your S3 bucket.
## Usage Demo
We can demonstrate the functionality of this UDF in Athena Spark.

First, execute the following Spark SQL code in a notebook cell to create a temporary function using the UDF:
```
%%sql
CREATE OR REPLACE TEMPORARY FUNCTION 
month_number_to_name as 'com.example.MonthNumbertoNameUDF'
using jar "s3://<your-bucket>/spark/udf/java/java-udf-demo-1.0"
```

Then test it:
```
%%sql
SELECT month_number_to_name(1)
```
Output should be:
```
January
```
## License
This library is licensed under the MIT-0 License. See the LICENSE file.This project is licensed under the MIT License - see the LICENSE file for details.