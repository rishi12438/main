package ducats.commands;

import ducats.DucatsException;
import ducats.Storage;
import ducats.Ui;
import ducats.components.SongList;
import ducats.components.UndoRedoStack;

public class UndoCommand extends Command<SongList> {

    @Override
    public String execute(SongList object, Ui ui, Storage storage) throws DucatsException {
        return null;
    }

    @Override
    public String execute(SongList songs, Ui ui, Storage storage, UndoRedoStack undoRedoStack) throws DucatsException {
        if (!undoRedoStack.canUndo()) {
            // cannot undo
            return ui.formatUndo();
        }

        // Can undo
        undoRedoStack.undo();
        storage.updateFile(undoRedoStack.getCurrentVersion());
        return ui.formatUndo(undoRedoStack.getCurrentVersionIndex());
    }

    @Override
    public boolean isExit() {
        return false;
    }

    //@@author rohan-av
    /**
     * Returns an integer corresponding to the duration, tempo and time signature if the command starts a metronome.
     * Else, returns an array containing -1.
     *
     * @return the integer array corresponding to the parameters of the Metronome class
     */
    @Override
    public int[] startMetronome() {
        return new int[]{-1, -1, -1, -1};
    }
}
