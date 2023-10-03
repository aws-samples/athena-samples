import calendar

# Following function converts a month name to a month number

def  month_number_to_name(month):
    
    try:

        if isinstance(month, str):

            month = int(month)

        return calendar.month_name[month]

    except ValueError:

        print("Invalid month number provided!")

    except IndexError:

        print("Month number out of range!")

    except Exception as e:

        print("Unexpected error occurred:", e)
