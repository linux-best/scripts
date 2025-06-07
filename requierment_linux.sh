directory=packages/requierment_linux.txt

function_version() {
	version=$($dir --version)
	if [ $? -eq 0 ]
	then
		echo "package available  ==> $dir $version"
	else
		echo "package not available ==> $dir $version"
		sudo apt install $dir 2> /dev/null
	fi
}

for dir in $(cat $directory)
do
	function_version $dir
done
