import subprocess
index = 0

def a(x):
    if x == 0 :
        print("ok")
    else:
        print("not ok")

def health_check(ip_address):
    global index
    command = ["ping",ip_address]
    ping_command = subprocess.run(command,capture_output=True,text=True)
    #exit_code = ping_command = subprocess.call(command)
    if ping_command.returncode == 0 :
        #print("the connection is OK !")
        #return exit_code
        pass
    else :
        #print("the connection is'nt Ok !")
        #return exit_code
        index+=1

lst = ["8.8.8.8","192.168.64.1"]
for i in lst:
    health_check(ip_address=i)
a(index)

