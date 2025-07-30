#!/bin/bash

LOG_FOLDER="/home/javande/logs/"
REPORT_FILE="Report_logs.txt"

ERROR_PATTERNS=("ERROR" "SUCCESS" "INFO")
LOG_FILES=$(find $LOG_FOLDER -name "*.log" -mtime -1)

echo "⚙️ Scan Started !" > $REPORT_FILE
echo "======================================" >> $REPORT_FILE
echo -e "\nFiles for searching patterns founded" >> $REPORT_FILE
echo "$LOG_FILES" >> $REPORT_FILE

for LOG_FILE in $LOG_FILES; do
        echo -e "\n============================================" >> $REPORT_FILE
        echo "=====$LOG_FILE=====" >> $REPORT_FILE
        echo -e "============================================\n" >> $REPORT_FILE

    for PATTERN in "${ERROR_PATTERNS[@]}"; do

        echo -e "\n🔎 searching for $PATTERN in $LOG_FILE" >> $REPORT_FILE
        grep "$PATTERN" $LOG_FILE >> $REPORT_FILE

        PATTERNS=$(grep -c "$PATTERN" $LOG_FILE) >> $REPORT_FILE
        echo -e "\nnumber of $PATTERN in $LOG_FILE" >> $REPORT_FILE
        echo "$PATTERNS" >> $REPORT_FILE

        if [ "$PATTERN" == "ERROR" ] && [ "$PATTERNS" -gt 5 ]; then
            echo -e "\n⚠️ Active Action Required : large number of $PATTERN founded \ndirectory:$LOG_FILE\nnumber:$PATTERNS $PATTERN"
        else
            echo "SUB-Scan Process Completed ✅: $LOG_FILE "
        fi
    done
done

echo "✅ Scan Procces Completed !" >> $REPORT_FILE
echo -e "\n✅ Scan Procces Completed ! check the reports in : $REPORT_FILE"

