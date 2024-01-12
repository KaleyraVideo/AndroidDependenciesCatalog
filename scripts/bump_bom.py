import semver
import fileinput
import argparse
import sys
import os

argParser = argparse.ArgumentParser()
argParser.add_argument("-cv", "--current_version", help="Current version", required=True)
argParser.add_argument("-nv", "--next_version", help="Release version(patch,minor,major,1.0.0-alpha01)", required=True)
args = argParser.parse_args()

def replace(filename, current_version, new_version):
    with fileinput.FileInput(filename, inplace=True) as file:
        for line in file:
            print(line.replace(current_version, new_version), end='')

def new_version(current_version, release_version):
    ver = semver.Version.parse(current_version)
    if release_version == "patch" or  release_version == "minor" or release_version == "major":
        new_version = ver.next_version(release_version)
    else:
        new_version = semver.Version.parse(release_version)
    return str(new_version)

def set_output(name, value):
    with open(os.environ['GITHUB_OUTPUT'], 'a') as fh:
        print(f'{name}={value}', file=fh)

try:
    current_version = args.current_version
    release_version = args.next_version
    new_version = new_version(current_version, release_version)
    # update
    print("Update Kaleyra Video SDK BOM from ",current_version," to ", new_version)
    replace("../buildSrc/src/main/kotlin/Consts.kt", current_version, new_version)
    set_output("TAG", "bom_v"+new_version)
except Exception as error:
    sys.exit("Did not update version" + error)