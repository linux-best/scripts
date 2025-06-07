import subprocess
index = 0

def a(x):
    if x == 0 :
        print("ok")
    else:
        print("not ok")

def health_check(ip_address):
    global index
    command = ["ping",ip_address,"-c","4"]
    ping_command = subprocess.run(command,capture_output=True,text=True)
    #exit_code = ping_command = subprocess.call(command)
    if ping_command.returncode == 0 :
        pass
    else:
        index+=1
lst = ["8.8.8.8","192.168.1.7"]
for i in lst:
    health_check(ip_address=i)
a(index)
