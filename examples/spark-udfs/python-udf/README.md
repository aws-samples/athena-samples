# Python UDF for Athena Spark
This is a sample User Defined Function (UDF) in Python that converts a month number to a month name. The purpose of this UDF to demonstrate UDF functionality in Athena Spark.

## Prerequisite
You need a Spark session to test the functionality of the UDF. Here, we will use Athena Spark. Please refer to the [Athena Spark getting started guide](https://docs.aws.amazon.com/athena/latest/ug/notebooks-spark-getting-started.html) to set up Athena Spark.

## Copy to S3
Copy the python file to an S3 bucket to be used later in Athena Spark:
```
aws s3 cp month_number_to_name.py s3://<your-bucket>/spark/udf/python/
```
Replace <your-bucket> with the name of your S3 bucket.
## Usage Demo
We can demonstrate the functionality of this UDF in Athena Spark.

First, execute the following pyspark code in a notebook cell to add the Python file, import the function, and register it as a UDF:
```python
sc.addPyFile('s3://<your-bucket>/spark/udf/python/month_number_to_name.py')

from month_number_to_name import month_number_to_name
spark.udf.register("month_number_to_name_py",month_number_to_name)
```

Then test it:
```sql
%%sql
SELECT month_number_to_name_py(1)
```
Output should be:
```
January
```
## License
This library is licensed under the MIT-0 License. See the LICENSE file.This project is licensed under the MIT License - see the LICENSE file for details.