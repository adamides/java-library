package com.urbanairship.api.nameduser.model;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/**
 * Named user listing response object.
 */
public class NamedUserListingResponse {
    private final boolean ok;
    private final Optional<String> nextPage;
    private final Optional<NamedUserView> namedUserView;
    private final Optional<ImmutableList<NamedUserView>> namedUserViews;

    private NamedUserListingResponse(boolean ok, Optional<String> nextPage, Optional<NamedUserView> namedUserView, Optional<ImmutableList<NamedUserView>> namedUserViews) {
        this.ok = ok;
        this.nextPage = nextPage;
        this.namedUserView = namedUserView;
        this.namedUserViews = namedUserViews;
    }

    /**
     * New NamedUserListingResponse builder.
     *
     * @return Builder
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Get the OK status as a boolean
     *
     * @return boolean
     */
    public boolean getOk() {
        return ok;
    }

    /**
     * Get the next page if present for a named user listing request
     *
     * @return An Optional String
     */
    public Optional<String> getNextPage() {
        return nextPage;
    }

    /**
     * Get the named user object if present for a single named user lookup request
     *
     * @return An Optional NamedUserView
     */
    public Optional<NamedUserView> getNamedUserView() {
        return namedUserView;
    }

    /**
     * Get a list of named user objects if present for a named user listing request
     *
     * @return An Optional ImmutableList of NamedUserView objects
     */
    public Optional<ImmutableList<NamedUserView>> getNamedUserViews() {
        return namedUserViews;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ok, nextPage, namedUserView, namedUserViews);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final NamedUserListingResponse other = (NamedUserListingResponse) obj;
        return Objects.equal(this.ok, other.ok) && Objects.equal(this.nextPage, other.nextPage) && Objects.equal(this.namedUserView, other.namedUserView) && Objects.equal(this.namedUserViews, other.namedUserViews);
    }

    @Override
    public String toString() {
        return "APIListSingleChannelResponse{" +
            "ok=" + ok +
            ", nextPage=" + nextPage +
            ", namedUserView=" + namedUserView +
            ", namedUserViews=" + namedUserViews +
            '}';
    }

    public static class Builder {

        private boolean ok;
        private String nextPage = null;
        private NamedUserView namedUserView = null;
        private ImmutableList.Builder<NamedUserView> namedUserViews = ImmutableList.builder();

        private Builder() {
        }

        /**
         * Set the ok status
         *
         * @param value boolean
         * @return Builder
         */
        public Builder setOk(boolean value) {
            this.ok = value;
            return this;
        }

        /**
         * Set the next page
         *
         * @param value String
         * @return Builder
         */
        public Builder setNextPage(String value) {
            this.nextPage = value;
            return this;
        }

        /**
         * Set the named user object for single named user lookup
         *
         * @param value NamedUserView
         * @return Builder
         */
        public Builder setNamedUserView(NamedUserView value) {
            this.namedUserView = value;
            return this;
        }

        /**
         * Add all the named user objects for named user listings
         *
         * @param value Iterable of NamedUserView objects
         * @return Builder
         */
        public Builder setNamedUserViews(Iterable<? extends NamedUserView> value) {
            this.namedUserViews.addAll(value);
            return this;
        }

        /**
         * Build the NamedUserListingResponse object
         *
         * <pre>
         * 1. If namedUserView is set, nextPage and namedUserView must be null.
         * </pre>
         *
         * @return NamedUserListingResponse
         */
        public NamedUserListingResponse build() {
            if (namedUserView != null) {
                Preconditions.checkArgument(nextPage == null && namedUserViews.build().isEmpty());
            }

            return new NamedUserListingResponse(ok, Optional.fromNullable(nextPage), Optional.fromNullable(namedUserView), Optional.fromNullable(namedUserViews.build()));
        }
    }
}