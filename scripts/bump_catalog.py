import semver
import fileinput
import argparse
import subprocess
import time

argParser = argparse.ArgumentParser()
argParser.add_argument("-cv", "--current_version", help="Current version", required=True)
argParser.add_argument("-nv", "--next_version", help="Specify a version", required=False)
args = argParser.parse_args()


def replace(filename, current_version, new_version):
    with fileinput.FileInput(filename, inplace=True) as file:
        for line in file:
            print(line.replace(current_version, new_version), end='')

def get_new_version(old_release):
    old_version = old_release.rpartition('.')
    old_year = old_version[0]
    old_month = old_version[1]
    old_day = old_version[2]
    next_version = time.strftime("%Y.%m.00").rpartition('.')
    next_year = next_version[0]
    next_month = next_version[1]
    if old_year == next_year and old_month == next_month:
        new_version = time.strftime("%Y.%m.") + str(int(old_day) + 1).zfill(2)
    else:
        new_version = time.strftime("%Y.%m.00")
    return new_version

try:
    current_version = args.current_version
    new_version = args.next_version
    if not new_version:
       new_version = get_new_version(current_version)
    # update
    print("Update Kaleyra Video SDK Catalog from ",current_version," to ", new_version)

    replace("../buildSrc/src/main/kotlin/Consts.kt", current_version, new_version)
    print("Updated!")
    print("Add changes to git")
    subprocess.run(["git", "add", "-A"])
    subprocess.run(["git", "commit","-m", f"Update catalog version to {new_version}"])
    subprocess.run(["git", "push"])
except Exception as error:
    print("Did not update version", error)