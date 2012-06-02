/*
 *      Copyright (c) 2004-2012 YAMJ Members
 *      http://code.google.com/p/moviejukebox/people/list
 *
 *      Web: http://code.google.com/p/moviejukebox/
 *
 *      This software is licensed under a Creative Commons License
 *      See this page: http://code.google.com/p/moviejukebox/wiki/License
 *
 *      For any reuse or distribution, you must make clear to others the
 *      license terms of this work.
 */
package com.moviejukebox.scanner.artwork;

import com.moviejukebox.model.IImage;
import com.moviejukebox.model.Jukebox;
import com.moviejukebox.model.Movie;

public interface IArtworkScanner {

    String scan(Jukebox jukebox, Movie movie);

    String scanLocalArtwork(Jukebox jukebox, Movie movie);

    String scanOnlineArtwork(Movie movie);

    boolean validateArtwork(IImage artworkImage);

    boolean validateArtwork(IImage artworkImage, int artworkWidth, int artworkHeight, boolean checkAspect);

    boolean saveArtworkToJukebox(Jukebox jukebox, Movie movie);

    /**
     * Updates the correct Filename based on the artwork type
     *
     * @param movie
     * @param artworkFilename
     */
    void setArtworkFilename(Movie movie, String artworkFilename);

    /**
     * Returns the correct Filename based on the artwork type This should be overridden at the artwork specific class
     * level
     *
     * @param movie
     * @return
     */
    String getArtworkFilename(Movie movie);

    /**
     * Updates the correct URL based on the artwork type
     *
     * @param movie
     * @param artworkUrl
     */
    void setArtworkUrl(Movie movie, String artworkUrl);

    /**
     * Returns the correct URL based on the artwork type
     *
     * @param movie
     * @return
     */
    String getArtworkUrl(Movie movie);

    /**
     * Sets the correct image plugin for the artwork type
     */
    void setArtworkImagePlugin();

    /**
     * Return the value of the appropriate "dirty" setting for the artwork and movie
     *
     * @param movie
     * @return
     */
    boolean isDirtyArtwork(Movie movie);

    /**
     * Set the appropriate "dirty" setting for the artwork and movie
     *
     * @param movie
     * @param dirty
     */
    void setDirtyArtwork(Movie movie, boolean dirty);

    /**
     * Determine if the artwork type is required.
     *
     * @return true if the artwork is required
     */
    boolean isSearchRequired();

    /**
     * Determine if the artwork type is required for local searching
     *
     * @return
     */
    boolean isSearchLocal();

    /**
     * Determine if an online search should be performed for a particular video.
     *
     * Properties should be checked as should scrape library and ID = 0/-1
     *
     * @param movie
     * @return true if online scraping should be done
     */
    boolean isSearchOnline(Movie movie);

    /**
     * Determine if an online search should be performed for a particular artwork.
     *
     * This only checks the properties and can't determine if the specific video artwork should be downloaded.
     *
     * @return true if online scraping should be done
     */
    boolean isSearchOnline();

    /**
     * Create a operating system safe filename for the artwork
     *
     * @param movie
     * @return
     */
    String makeSafeArtworkFilename(Movie movie);
}
