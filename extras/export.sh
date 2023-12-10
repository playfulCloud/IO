#!/bin/sh
source ./config.sh

if [ -f "$VISUAL_PARADIGM_EXPORT_SCRIPT" ]; then
    echo "Exporting diagram images..."
else
    echo "Initializing export script..."
    cp "$VISUAL_PARADIGM_DIRECTORY/scripts/ExportDiagramImage.sh" "$VISUAL_PARADIGM_DIRECTORY/bin/"
    chmod 775 $VISUAL_PARADIGM_EXPORT_SCRIPT
    chmod 775 . -R
fi

rm *.png

cd "$VISUAL_PARADIGM_DIRECTORY/bin"
$VISUAL_PARADIGM_EXPORT_SCRIPT -project $PROJECT_FILE_PATH -diagram "*" -type png -out $DIAGRAM_IMAGE_DIRECTORY
echo "Done exporting diagram images."