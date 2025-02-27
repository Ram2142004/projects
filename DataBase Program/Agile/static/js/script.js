
loadDropdowns(); 


class CustomUserDropdown {
    constructor(dropdownElement) {
        this.dropdownElement = dropdownElement;
        this.listElement = document.getElementById('userDropdownList');
        this.hiddenInput = document.getElementById('selected-user-ids');
        this.selectedUserIds = [];
        this.init();
    }

    init() {
        this.loadUsers();
        this.setupOutsideClickListener();
    }

    async loadUsers() {
        try {
            const response = await fetch('/api/users');
            const users = await response.json();

            this.renderUsers(users);
            this.setupEventListeners();
        } catch (error) {
            console.error('Error loading users:', error);
        }
    }

    renderUsers(users) {
        this.listElement.innerHTML = users.map(user => `
            <div class="dropdown-item">
                <input 
                    type="checkbox" 
                    id="user-${user.id}" 
                    value="${user.id}"
                    onchange="customUserDropdown.updateSelectedUsers(this)"
                >
                <label for="user-${user.id}">${user.name}</label>
            </div>
        `).join('');
    }

    updateSelectedUsers(checkbox) {
        const userId = checkbox.value;

        if (checkbox.checked) {
            if (!this.selectedUserIds.includes(userId)) {
                this.selectedUserIds.push(userId);
            }
        } else {
            this.selectedUserIds = this.selectedUserIds.filter(id => id !== userId);
        }

        // Update hidden input
        this.hiddenInput.value = this.selectedUserIds.join(',');

        // Update dropdown header
        this.updateDropdownHeader();
    }

    updateDropdownHeader() {
        const headerElement = this.dropdownElement.querySelector('.dropdown-header');
        if (this.selectedUserIds.length > 0) {
            headerElement.innerHTML = `
                Selected Users (${this.selectedUserIds.length}) 
                <span>▼</span>
            `;
        } else {
            headerElement.innerHTML = `
                Select Users 
                <span>▼</span>
            `;
        }
    }
    setupEventListeners() {
       
    }

    setupOutsideClickListener() {
        document.addEventListener('click', (event) => {
            if (!this.dropdownElement.contains(event.target)) {
                this.listElement.classList.remove('show');
            }
        });
    }
}

// Global function to toggle dropdown visibility
function toggleDropdown() {
    const dropdownList = document.getElementById('userDropdownList');
    //dropdownList.classList.toggle('show');
    dropdownList.style.display = dropdownList.style.display === "block" ? "none" : "block";

}

// Initialize dropdown when page loads
let customUserDropdown;
document.addEventListener('DOMContentLoaded', () => {
    const dropdownElement = document.querySelector('.custom-dropdown');
    customUserDropdown = new CustomUserDropdown(dropdownElement);
});


async function loadDropdowns() {
    try {
        // Fetch Product Owner data
        const response = await fetch('/api/product_owners');
        const productOwners = await response.json();

        const productOwnerSelect = document.getElementById('product-owner-id');
        productOwners.forEach(owner => {
            const option = document.createElement('option');
            option.value = owner.id; 
            option.textContent = owner.name; // Use a meaningful label
            productOwnerSelect.appendChild(option);
        });
    } catch (error) {
        console.error('Error loading dropdown data:', error);
    }
}

async function ScrumMasterDropdown(targetId) {
try {
    // Fetch Scrum Master data
    const response = await fetch('/api/scrum_masters');
    const scrumMasters = await response.json();

    const scrumMasterSelect = document.getElementById(targetId);
    scrumMasterSelect.innerHTML = `<option value="">Select Scrum Master</option>`; // Clear existing options

    scrumMasters.forEach(master => {
        const option = document.createElement('option');
        option.value = master.id; // Use the ID from the database
        option.textContent = master.name; // Use a meaningful label
        scrumMasterSelect.appendChild(option);
    });
    } 
    catch (error) {
        console.error('Error loading Scrum Master data:', error);
    }
}


function addSprintFields() {
    const numSprints = parseInt(document.getElementById("num-sprints").value);
    if (isNaN(numSprints) || numSprints < 1) {
        alert("Please enter a valid number of sprints.");
        return;
    }

    const sprintContainer = document.getElementById("sprint-container");
    sprintContainer.innerHTML = ""; // Clear previous content

    for (let i = 1; i <= numSprints; i++) {
        const sprintId = `scrum-master-id-${i}`; // Unique ID for each dropdown

        sprintContainer.innerHTML += `
            <div class="sprint-section">
                <h4>Sprint ${i}</h4>

                <label for="${sprintId}">Scrum Master</label>
                <select id="${sprintId}" name="scrum_master_id_${i}" required>
                    <option value="">Select Scrum Master</option>
                </select>

                <label for="sprint-start-date-${i}">Start Date</label>
                <input type="date" id="sprint-start-date-${i}" name="sprint_start_date_${i}" required>

                <label for="sprint-end-date-${i}">End Date</label>
                <input type="date" id="sprint-end-date-${i}" name="sprint_end_date_${i}" required>

                <label for="sprint-velocity-${i}">Velocity</label>
                <input type="number" id="sprint-velocity-${i}" name="sprint_velocity_${i}" required>

                <button type="button" onclick="addUserStoryFields(${i})">Add User Stories for Sprint ${i}</button>
                <div id="user-stories-${i}"></div>
            </div>
        `;

        // Populate the Scrum Master dropdown for this sprint
        ScrumMasterDropdown(sprintId);
    }
}

function addUserStoryFields(sprintNum) {
    const numStories = prompt(`How many user stories for Sprint ${sprintNum}?`);
    if (isNaN(numStories) || numStories < 1) {
        alert("Please enter a valid number.");
        return;
    }

    const storyContainer = document.getElementById(`user-stories-${sprintNum}`);
    storyContainer.innerHTML = ""; // Clear previous content

    for (let i = 1; i <= numStories; i++) {
        storyContainer.innerHTML += `
            <div class="user-story-section">
                <h5>User Story ${i}</h5>
                <label for="planned-sprint-${sprintNum}-${i}">Planned Sprint</label>
                <input type="number" id="planned-sprint-${sprintNum}-${i}" name="planned_sprint_${sprintNum}_${i}" required>

                <label for="actual-sprint-${sprintNum}-${i}">Actual Sprint</label>
                <input type="number" id="actual-sprint-${sprintNum}-${i}" name="actual_sprint_${sprintNum}_${i}" required>
                  
                <label for="story-desc-${sprintNum}-${i}">Description</label>
                <textarea id="story-desc-${sprintNum}-${i}" name="story_desc_${sprintNum}_${i}" required></textarea>

                <label for="story-points-${sprintNum}-${i}">Story Points</label>
                <input type="number" id="story-points-${sprintNum}-${i}" name="story_points_${sprintNum}_${i}" required>

                <label for="moscow-${sprintNum}-${i}">MoSCoW</label>
                <select id="moscow-${sprintNum}-${i}" name="moscow_${sprintNum}_${i}" required>
                    <option value="Must Have">Must Have</option>
                    <option value="Should Have">Should Have</option>
                    <option value="Could Have">Could Have</option>
                    <option value="Won't Have">Won't Have</option>
                </select>

                <label for="assignee-${sprintNum}-${i}">Assignee</label>
                <input type="text" id="assignee-${sprintNum}-${i}" name="assignee_${sprintNum}_${i}" required>

                <label for="status-${sprintNum}-${i}">Status</label>
                <select id="status-${sprintNum}-${i}" name="status_${sprintNum}_${i}" required>
                    <option value="Not Started">Not Started</option>
                    <option value="In Progress">In Progress</option>
                    <option value="Completed">Completed</option>
                </select>
            </div>
        `;
    }
}

function validateForm() {
    // Check if required fields are filled
    const projectName = document.getElementById('project-name')?.value.trim();
    const numSprints = document.getElementById('num-sprints')?.value;
    const productOwner = document.getElementById('product-owner-id')?.value;
    const selectedUserIds = document.getElementById('selected-user-ids')?.value;
    const startdate = document.getElementById('start-date')?.value;
    const enddate = document.getElementById('end-date')?.value;
    const rev_date = document.getElementById('revised-end-date')?.value;
    const project_desc = document.getElementById('project-desc')?.value;
    
    if (!projectName) {
        alert("Project Name is required.");
        return false;
    }

    if (!productOwner) {
        alert("Please select a Product Owner.");
        return false;
    }

    if (!selectedUserIds) {
        alert("Please select at least one user.");
        return false;
    }

    if (!project_desc){
        alert("Please enter project descriptiuon");
        return false;
    }
    if (!startdate){
        alert("Please select project start date");
        return false;
    }
    if (!enddate){
        alert("Please select project end date");
        return false;
    }
    if (!rev_date){
        alert("Please select project revised end date");
        return false;
    }

    if (new Date(enddate) <= new Date(startdate)) {
        alert('End date must be later than the start date.');
        return false; 
    }

    if (isNaN(numSprints) || numSprints < 1) {
        alert("Please enter a valid number of sprints.");
        return false;
    }


    // Validate each sprint's fields
    for (let i = 1; i <= numSprints; i++) {
        const startDate = document.getElementById(`sprint-start-date-${i}`)?.value;
        const endDate = document.getElementById(`sprint-end-date-${i}`)?.value;
        const scrumMaster = document.getElementById(`scrum-master-id-${i}`)?.value;

        if (!startDate) {
            alert(`Sprint ${i}: Start Date is required.`);
            return false;
        }

        if (!endDate) {
            alert(`Sprint ${i}: End Date is required.`);
            return false;
        }

        if (new Date(startDate) > new Date(endDate)) {
            alert(`Sprint ${i}: Start Date cannot be after End Date.`);
            return false;
        }

        if (!scrumMaster) {
            alert(`Sprint ${i}: Scrum Master is required.`);
            return false;
        }

        // Validate user stories for this sprint
        const storyContainer = document.getElementById(`user-stories-${i}`);
        if (storyContainer) {
            const userStorySections = storyContainer.querySelectorAll(".user-story-section");

            userStorySections.forEach((section, index) => {
                const description = section.querySelector(`#story-desc-${i}-${index + 1}`)?.value;
                const storyPoints = section.querySelector(`#story-points-${i}-${index + 1}`)?.value;

                if (!description) {
                    alert(`Sprint ${i}, User Story ${index + 1}: Description is required.`);
                    return false;
                }

                if (isNaN(storyPoints) || storyPoints < 1) {
                    alert(`Sprint ${i}, User Story ${index + 1}: Story Points must be a positive number.`);
                    return false;
                }
            });
        }
    }

    // If all validations pass
    return true;
}


function submitForm1() {
    if (!validateForm()) {
        return; // Stop form submission
    }
    // Collect basic form data
    const form = document.getElementById("project-form");
    const formData = new FormData(form);
    const jsonData = {};

    // Convert FormData to a plain object
    for (let [key, value] of formData.entries()) {
        jsonData[key] = value;
    }

    // Add selected user IDs
    const selectedUserIds = document.getElementById('selected-user-ids').value;
    jsonData['selected_user_ids'] = selectedUserIds;

    // Handle Sprint Data
    jsonData.sprints = [];
    const numSprints = parseInt(document.getElementById("num-sprints").value);

    for (let i = 1; i <= numSprints; i++) {
        const sprint = {
            start_date: document.getElementById(`sprint-start-date-${i}`)?.value,
            end_date: document.getElementById(`sprint-end-date-${i}`)?.value,
            scrum_master_id: document.getElementById(`scrum-master-id-${i}`)?.value,
            velocity: document.getElementById(`sprint-velocity-${i}`)?.value,
            user_stories: []
        };

        // Collect user stories for this sprint
        const storyContainer = document.getElementById(`user-stories-${i}`);
        if (storyContainer) {
            const userStorySections = storyContainer.querySelectorAll(".user-story-section");
            
            userStorySections.forEach((section, index) => {
                const story = {
                    planned_sprint: section.querySelector(`#planned-sprint-${i}-${index + 1}`)?.value,
                    actual_sprint: section.querySelector(`#actual-sprint-${i}-${index + 1}`)?.value,
                    description: section.querySelector(`#story-desc-${i}-${index + 1}`)?.value,
                    story_points: section.querySelector(`#story-points-${i}-${index + 1}`)?.value,
                    moscow: section.querySelector(`#moscow-${i}-${index + 1}`)?.value,
                    assignee: section.querySelector(`#assignee-${i}-${index + 1}`)?.value,
                    status: section.querySelector(`#status-${i}-${index + 1}`)?.value
                };
                sprint.user_stories.push(story);
            });
        }

        jsonData.sprints.push(sprint);
    }

    // Log the data for debugging
    console.log('Submission Data:', jsonData);

    // Send data to server
    fetch("/submit", {
        method: "POST",
        headers: { 
            "Content-Type": "application/json",
            "Accept": "application/json"
        },
        body: JSON.stringify(jsonData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        // Handle successful submission
        alert(data.message);
        window.location.href = data.redirect;
        

    })
    .catch(error => {
        console.error("Error submitting form:", error);
        alert("Failed to submit project. Please try again.");
    });
}