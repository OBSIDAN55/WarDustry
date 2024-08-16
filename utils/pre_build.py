import datetime
import hashlib
from pathlib import Path
import os

os.chdir(os.path.dirname(__file__))

print(r"   _____            _                      ")
print(r"  / ____|          | |                     ")
print(r" | |    _   _ _ __ | | __ _ _ __ __ ___  __")
print(r" | |   | | | | '_ \| |/ _` | '__/ _` \ \/ /")
print(r" | |___| |_| | |_) | | (_| | | | (_| |>  < ")
print(r"  \_____\__,_| .__/|_|\__,_|_|  \__,_/_/\_\\")
print(r"             | |                           ")
print(r"             |_|                           ")

HASH_HEX_COLOR = "[#ffbe00]"
VERSION = "test_2.0"
all_paths = []

for path in Path('../src').rglob('*.java'):
    if path.name.split('.')[0] != 'ResGenPreBuild':
        all_paths.append(str(path))

hash = b''

for path in all_paths:
    hash += hashlib.md5(open(path, 'rb').read()).digest()

today = datetime.datetime.now()

days = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 303, 334, 365]
num = 365 * (today.year - 2020) - 31 + days[(today.month - 1)] + today.day

hash = hashlib.shake_256(hash).hexdigest(length=2)

with open('version_info', 'w') as info_file:
    info_file.write(f"{VERSION}_{str(num)}{hash}")

with open("./../src/Cuplarax/ResGenPreBuild.java", "w") as file:
    file.write(
        """package Cuplarax;
    
    public class ResGenPreBuild {
        public static final String version_num =        "VER";
        public static final String build_num =          "NUM";
        public static final String build_num_wo_color = "NO_COLOR";
    }"""
        .replace('NUM', str(num) + HASH_HEX_COLOR + hash)
        .replace('NO_COLOR', str(num) + hash)
        .replace('VER', VERSION)
    )

print('ver:', VERSION)
print('build:', str(num) + hash)
