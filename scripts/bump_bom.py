import semver
import fileinput
import argparse
import subprocess

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

try:
    current_version = args.current_version
    release_version = args.next_version
    new_version = new_version(current_version, release_version)
    # update
    print("Update Kaleyra Video SDK BOM from ",current_version," to ", new_version)

    replace("../buildSrc/src/main/kotlin/Consts.kt", current_version, new_version)
    print("Updated!")
    print("Add changes to git")
    subprocess.run(["git", "add", "-A"])
    subprocess.run(["git", "commit","-m", f"Update bom version to {new_version}"])
    subprocess.run(["git", "push"])
except Exception as error:
    print("Did not update version", error)