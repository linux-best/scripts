directory=packages/requierment_linux.txt
num=1

function_version() {
	version=$($dir --version)
	if [ $? -eq 0 ]
	then
		echo "package available  ==> $dir $version"
	else
		echo "package not available ==> $dir $version"
		sudo apt install $dir -y 2> /dev/null
	fi
}

for dir in $(cat $directory)
do
	function_version $dir
	sleep 1.5
	echo "Complete $num/5 Packages"
	num=$(($num+1))
done
