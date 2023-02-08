# Startup text
echo "/**             Simple Java compiler             **/"
echo " -  clemencedev (https://github.com/clemencedev)  -"
echo "/**                                              **/"
echo ""

# Get the current directory
SCRIPT_DIR=$(cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

# Execute the program
echo " * Executing the program!"
java -cp $SCRIPT_DIR/bin clemencedev.javachrono.main.Hello
