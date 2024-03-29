import fileinput
import argparse
import re
import sys

argParser = argparse.ArgumentParser()
argParser.add_argument("-n", "--library_name", help="Library name to update", required=True)
argParser.add_argument("-v", "--library_version", help="Library version to update", required=True)
args = argParser.parse_args()

regex = r"(?P<major>0|[1-9]\d*)\.(?P<minor>0|[1-9]\d*)\.(?P<patch>0|[1-9]\d*)(?:-(?P<prerelease>(?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\.(?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\+(?P<buildmetadata>[0-9a-zA-Z-]+(?:\.[0-9a-zA-Z-]+)*))?"

def replace(filename, library_name, library_version):
    with fileinput.FileInput(filename, inplace=True) as file:
        for line in file:
            if library_name in line:
                line = re.sub(regex, library_version, line)
            print(line, end='')

try:
    library_name = args.library_name
    library_version = args.library_version
    # update
    print("Update ",library_name ," : ", library_version)

    replace("../buildSrc/src/main/kotlin/dependencies/KaleyraDependencies.kt", library_name, library_version)
except Exception as error:
    sys.exit("Did not update version" + error)
