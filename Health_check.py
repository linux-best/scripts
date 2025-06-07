import subprocess
index = 0
count=0

def a(x,z):
    if x>z :
        return 1
    else:
        return 0

def health_check(ip_address):
    global index
    command = ["ping","-c","4",ip_address]
    ping_command = subprocess.run(command,capture_output=True,text=True)
    #exit_code = ping_command = subprocess.call(command)
    if ping_command.returncode == 0 :
        #print("the connection is OK !")
        #return exit_code
        count+1 
    else :
        #print("the connection is'nt Ok !")
        #return exit_code
        index+=1

lst = ["8.8.8.8","192.168.1.8"]
for i in lst:
    health_check(ip_address=i)
a(index,count)
