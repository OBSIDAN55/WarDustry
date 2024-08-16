import os
from zipfile import ZipFile
import shutil

os.chdir(os.path.dirname(__file__))

dir_name = "../build/libs/"
dir_obj = os.listdir(dir_name)
game_mods_path = os.path.join(os.getenv("APPDATA"), "Mindustry/mods")

for file in dir_obj:
    if file.endswith(".zip"):
        os.remove(os.path.join(dir_name, file))

with open('version_info', 'r') as vi:
    ver = vi.read()

shutil.copy2(os.path.join(dir_name, 'ResGenDesktop.jar'), game_mods_path)

new_path = os.path.join(dir_name, f'ResGen_{ver}Desktop')
with ZipFile(new_path + '.zip', 'w') as file:
    file.write(os.path.join(dir_name, 'ResGenDesktop.jar'), arcname=f'ResGen_{ver}Desktop.jar')
