# Arguments & Dependencies
backup_source=$1
backup_destination=$2
backup_Display_name=$3

# Backup_Command
tar -cvpzf $backup_Display_name.tar.gz $backup_source && mv $backup_Display_name.tar.gz $backup_destination

# Exit_check_code
if [ $? -eq 0 ]
then
	echo "Backup Completed !"
else
	echo "Backup Failed !!"
fi
